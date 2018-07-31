package com.example.msi_gl62.edr.fragment;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.example.msi_gl62.edr.R;

public class FeedTimetableFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    public FeedTimetableFragment() { }

    public static FeedTimetableFragment newInstance(String param1, String param2) {
        FeedTimetableFragment fragment = new FeedTimetableFragment();
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
        View view = inflater.inflate(R.layout.fragment_feed_timetable, container, false);
        setWebView(view);
        return view;
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void setWebView(View view) {
        SharedPreferences sp = this.getActivity().getSharedPreferences("PREF_NAME", Context.MODE_PRIVATE);
        String app_edr_ipaddress = sp.getString("app_edr_ipaddress", "");
        SharedPreferences data = this.getActivity().getSharedPreferences("DATA", Context.MODE_PRIVATE);
        String teacher_id = data.getString("teacher_id", "");
        WebView webViw = view.findViewById(R.id.webView);
        webViw.setWebViewClient(new WebViewClient());
        webViw.getSettings().setJavaScriptEnabled(true);
        webViw.loadUrl("http://"+app_edr_ipaddress+"/edr/mobileTeacherTimeTableApp.do?teacherId=_"+""+teacher_id);
    }

}
