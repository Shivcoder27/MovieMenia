package com.example.moviemenia;

import static android.content.Context.DOWNLOAD_SERVICE;
//import static androidx.core.content.ContextCompat.getSystemService;

import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link navHome#newInstance} factory method to
 * create an instance of this fragment.
 */
public class navHome extends Fragment {
private WebView webView;
    private HomeActivity.MyChrome chrome;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public navHome() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment navHome.
     */
    // TODO: Rename and change types and number of parameters
    public static navHome newInstance(String param1, String param2) {
        navHome fragment = new navHome();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nav_home, container, false);
        webView = view.findViewById(R.id.webView);
        Intent intent = new Intent(getActivity(),HomeActivity.class);
        startActivity(intent);
        //////////////////////////////////////////////////////////////////////////////////////
        // i don't need this code i send to homeActivity when anyone click on home from navbar

//
//        webView.getSettings().setJavaScriptEnabled(true); // true/false to enable disable JavaScript support
//        webView.getSettings().setUserAgentString(new WebView(this.getContext()).getSettings().getUserAgentString()); //set default user agent as of Chrome
//        webView.setWebViewClient(new WebViewClient()); //we would be overriding WebViewClient() with custom methods
//         //webView.setWebChromeClient(new HomeActivity().MyChrome); //we would be overriding WebChromeClient() with custom methods.
//        webView.setWebChromeClient(chrome);
//        webView.loadUrl("https://www.youtube.com/"); // website on app launch
//        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
//        webView.getSettings().setLoadsImagesAutomatically(true);
//        webView.getSettings().setJavaScriptEnabled(true);
//        webView.getSettings().setLoadWithOverviewMode(true);
//        webView.getSettings().setUseWideViewPort(true);
//        WebSettings webSettings = webView.getSettings();
//        ////////////////////////////////////////////////////////////////
//        webView.setDownloadListener(new DownloadListener() {
//            public void onDownloadStart(String url, String userAgent,
//                                        String contentDisposition, String mimetype,
//                                        long contentLength) {
//                Intent i = new Intent(Intent.ACTION_VIEW);
//                i.setData(Uri.parse(url));
//                startActivity(i);
//            }
//        });
//        //////////////////////////////////////////////
//        webView.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View view, int i, KeyEvent keyEvent) {
//                if(keyEvent.getAction()==keyEvent.ACTION_DOWN){
//                    if(i==keyEvent.KEYCODE_BACK){
//                        if(webView!=null){
//                            if(webView.canGoBack()){
//                                webView.goBack();
//                            }
//                            else{
//                                getActivity().onBackPressed();
//                            }
//                        }
//                    }
//                }
//                return true;
//            }
//        });


//        webView.setDownloadListener(new DownloadListener() {
//
//            @Override
//            public void onDownloadStart(String url, String userAgent,
//                                        String contentDisposition, String mimetype,
//                                        long contentLength) {
//                DownloadManager.Request request = new DownloadManager.Request(
//                        Uri.parse(url));
//
//                request.allowScanningByMediaScanner();
//                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED); //Notify client once download is completed!
//                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "Name of your downloadble file goes here, example: Mathematics II ");
//                DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
//                dm.enqueue(request);
//               // Toast.makeText(getApplicationContext(), "Downloading File", //To notify the Client that the file is being downloaded
//                    //    Toast.LENGTH_LONG).show();
//
//            }
//        });


        return  view;
    }

}