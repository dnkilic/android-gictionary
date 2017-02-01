package com.dnkilic.gictionary;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.SearchManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

public class DictionaryFragment extends Fragment implements TranslationListener {

    private TranslationManager mTranslationManager;
    private ViewManager mViewManager;
    private View mProgressView;
    private long mLastClickTime = 0;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private AdView mAdView;

    private static String TAG = "Dictionary";

    public DictionaryFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
        mTranslationManager = new TranslationManager(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dictionary, container, false);

        mViewManager = new ViewManager(view, getResources());

        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        String selectedSourceLanguage = sharedPref.getString(getResources().getString(R.string.pref_source_language), "");
        String selectedDestinationLanguage = sharedPref.getString(getResources().getString(R.string.pref_destination_language), "");

        mViewManager.initializeButtons(selectedSourceLanguage, selectedDestinationLanguage);

        mProgressView = view.findViewById(R.id.pbTranslate);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rvWords);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new GridLayoutManager(getActivity(), 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdView = (AdView) view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void showProgress(final boolean show) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.main, menu);

        SearchManager searchManager =
                (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();

        if(((AppCompatActivity) getActivity()).getSupportActionBar() != null)
        {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setCustomView(searchView);
            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        }

        searchView.setFocusable(true);
        searchView.setIconifiedByDefault(false);
        searchView.requestFocusFromTouch();

        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getActivity().getComponentName()));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                if (SystemClock.elapsedRealtime() - mLastClickTime < 2000) {
                    return false;
                }

                showProgress(true);
                mLastClickTime = SystemClock.elapsedRealtime();
                mTranslationManager.makeTranslationRequest(mViewManager.getSelectedSourceLanguage().toString(), mViewManager.getSelectedDestinationLanguage().toString(), query.trim());
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onSuccess(ArrayList<Word> words) {
        showProgress(false);
        //Log.d(TAG ,words.toString());

        mAdapter = new WordAdapter(words);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onError(String localError) {
        showProgress(false);
        //Log.d(TAG, localError);
        showErrorDialog(localError);
    }

    private void showErrorDialog(String error) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AlertDialogStyle);
        builder.setMessage(error);
        builder.setPositiveButton(getResources().getString(R.string.btn_ok), null);
        builder.show();
    }
}
