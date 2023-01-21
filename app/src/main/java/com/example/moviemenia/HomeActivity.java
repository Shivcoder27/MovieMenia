package com.example.moviemenia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
//import android.webkit.DownloadListener;
import android.view.MenuItem;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {


    /////////////////////////////////////////////////////
    WebView webView;
    Toolbar toolbar;
    DrawerLayout drawer;
    ProgressBar progressBar;
    NavigationView navigationView;


    @SuppressLint("MissingInflatedId")

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
       // webView = findViewById(R.id.webView);
        webView=(WebView) findViewById(R.id.webView);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.nav_view);
        progressBar = findViewById(R.id.progressBar);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer=findViewById(R.id.drawer_layout);





        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,drawer,toolbar,R.string.OpenDrawer,R.string.CloseDrawer);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        ////////////////////////////////////////////////////////////////////////////////
        webView.getSettings().setJavaScriptEnabled(true); // true/false to enable disable JavaScript support
        webView.getSettings().setUserAgentString(new WebView(this).getSettings().getUserAgentString()); //set default user agent as of Chrome
        webView.setWebViewClient(new WebViewClient()); //we would be overriding WebViewClient() with custom methods
         webView.setWebChromeClient(new MyChrome()); //we would be overriding WebChromeClient() with custom methods.
        //  webView.loadUrl("https://m4ufree.vip/home"); // website on app launch
        webView.setWebChromeClient(new MyChrome());
        webView.loadUrl("https://katmovie.tech/");

    //    ?????????????????????????????????????????????????????????????
//        webView.setDownloadListener(new DownloadListener() {
//            @Override
//            public void onDownloadStart(String s, String s1, String s2, String s3, long l) {
//                DownloadManager.Request myRequest = new DownloadManager.Request(Uri.parse(s));
//                myRequest.allowScanningByMediaScanner();
//                myRequest.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
//                DownloadManager myManager =(DownloadManager) getSystemService(DOWNLOAD_SERVICE);
//                myManager.enqueue(myRequest);
//                Toast.makeText(HomeActivity.this, "File start downloading..", Toast.LENGTH_SHORT).show();
//            }
//        });
///////////////////////////////////////////////////////////////////////////////////
        // for handling error in case of no internet


       ///////////////////////////////////////////////////////////////////////////////
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                progressBar.setVisibility(view.VISIBLE);
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                progressBar.setVisibility(view.GONE);
                super.onPageFinished(view, url);
            }
        });
        //////////////////////////////////////////////////////////////////
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if(id==R.id.nav_home){
                    loadFragment(new navHome());
                }else if(id==R.id.movieLink1){
                    loadFragment(new MovieLink1());}
                  else if(id==R.id.movieLink2){
                      loadFragment(new MovieLink2());
                  }else if(id==R.id.movieLink3){
                      loadFragment(new MovieLink3());
                  }else if(id==R.id.savFnet){
                     loadFragment(new SaveFromnet());
                  }else if(id==R.id.devInfo){
                      loadFragment(new developerInfo());
                  } else if(id==R.id.chatgpt){
                    loadFragment(new chatGPT());
                }
                return true;
            }
        });



/////////////////////////////////////////////////////////////////////////////////
        webView.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String url, String userAgent,
                                        String contentDisposition, String mimetype,
                                        long contentLength) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
       ////////////////////////////////////////////////////////////////////////////////
    }
    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(R.id.container,fragment);
        ft.commit();
    }

    //on back press if nav bar is opened then close
    @Override
    public void onBackPressed() {
        if (webView.canGoBack() || drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    // for full screen view

        ////////////////////////////////////////////////////////////////////////////////////////////////////

        class MyChrome extends WebChromeClient {
            private View mCustomView;
            private CustomViewCallback mCustomViewCallback;
            protected FrameLayout mFullscreenContainer;
            private int mOriginalOrientation;
            private int mOriginalSystemUiVisibility;

            MyChrome() {
            }

            public Bitmap getDefaultVideoPoster() {
                if (mCustomView == null) {
                    return null;
                }
                return BitmapFactory.decodeResource(getApplicationContext().getResources(), 2130837573);
            }

            public void onHideCustomView() {
                ((FrameLayout) getWindow().getDecorView()).removeView(this.mCustomView);
                this.mCustomView = null;
                getWindow().getDecorView().setSystemUiVisibility(this.mOriginalSystemUiVisibility);
                setRequestedOrientation(this.mOriginalOrientation);
                this.mCustomViewCallback.onCustomViewHidden();
                this.mCustomViewCallback = null;
            }

            public void onShowCustomView(View paramView, CustomViewCallback paramCustomViewCallback) {
                if (this.mCustomView != null) {
                    onHideCustomView();
                    return;
                }
                this.mCustomView = paramView;
                this.mOriginalSystemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();
                this.mOriginalOrientation = getRequestedOrientation();
                this.mCustomViewCallback = paramCustomViewCallback;
                ((FrameLayout) getWindow().getDecorView()).addView(this.mCustomView, new FrameLayout.LayoutParams(-1, -1));
                getWindow().getDecorView().setSystemUiVisibility(3846);
            }
        }
        /////////////////////////////////////////////////////////////////////////////////////////
        // some other configuration

        @Override
        public void onConfigurationChanged (Configuration newConfig){
            super.onConfigurationChanged(newConfig);
        }

        @Override
        protected void onSaveInstanceState (Bundle outState )
        {
            super.onSaveInstanceState(outState);
            webView.saveState(outState);
        }

        @Override
        protected void onRestoreInstanceState (Bundle savedInstanceState)
        {
            super.onRestoreInstanceState(savedInstanceState);
            webView.restoreState(savedInstanceState);
        }


    }

