package com.example.danman.translator.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.danman.translator.App;
import com.example.danman.translator.R;
import com.example.danman.translator.api.ApiSettings;
import com.example.danman.translator.contract.TranslationContract;
import com.example.danman.translator.manager.SpinnerManager;
import com.example.danman.translator.model.TranslationResult;
import com.example.danman.translator.presenter.TranslationPresenter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by DanMan on 01.12.2016.
 */
public class MainActivity extends AppCompatActivity implements TranslationContract.View {
    private Toolbar mToolbar;
    private FloatingActionButton mTranslateFAB;
    private TextView mResultTV;
    private EditText mSourceET;
    private TranslationPresenter mTranslationPresenter;
    private Map<String, String> mFields;
    private Spinner mFromSpinner;
    private Spinner mToSpinner;
    private SpinnerManager mSpinnerManager;
    private RelativeLayout mRelativeLayout;
    private final String TAG = "ApiError";
    private final String KEY = "key";
    private final String LANGUAGE = "lang";
    private final String TEXT = "text";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_layout);
        mFields = new HashMap<>();
        mFields.put(KEY, ApiSettings.API_KEY);
        mTranslationPresenter = new TranslationPresenter();
        mTranslationPresenter.attachView(this);
        mSpinnerManager = App.getSpinnerManager();
        initViews();
    }

    private void initViews() {
        mToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        mToolbar.setTitle(R.string.app_name);
        setSupportActionBar(mToolbar);
        mTranslateFAB = (FloatingActionButton) findViewById(R.id.main_fab);
        mSourceET = (EditText) findViewById(R.id.source_et);
        mResultTV = (TextView) findViewById(R.id.result_tv);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.main_relative_layout);
        initSpinners();
        initFAB();
    }

    private void initFAB() {
        mTranslateFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mTranslationPresenter.isOnline()) {
                    mFields.put(TEXT, mSourceET.getText().toString());
                    mFields.put(LANGUAGE, mSpinnerManager.getLngPair(mFromSpinner, mToSpinner));
                    mTranslationPresenter.translate(mFields);
                } else {
                    Snackbar.make(mRelativeLayout, R.string.connection_troubles, Snackbar.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initSpinners() {
        mFromSpinner = (Spinner) findViewById(R.id.from_spinner);
        mToSpinner = (Spinner) findViewById(R.id.to_spinner);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,
                mSpinnerManager.getNamesList());
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        mFromSpinner.setAdapter(arrayAdapter);
        mToSpinner.setAdapter(arrayAdapter);
    }

    @Override
    public void onTranslationResult(TranslationResult result) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] results = result.getText();
        for (String st : results)
            stringBuilder.append(st + " ");
        mResultTV.setText(stringBuilder.toString());
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void onError(Throwable throwable) {
        Log.e(TAG, throwable.getMessage());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mTranslationPresenter.detachView();
    }
}
