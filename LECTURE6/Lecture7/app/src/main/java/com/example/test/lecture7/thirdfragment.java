package com.example.test.lecture7;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link thirdfragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class thirdfragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String tvDisplay = "param1";
    public static String TAG="mainactivity";
    public OnCreateViewListner ocvl;

    // TODO: Rename and change types of parameters
    private String mParam1;

    public void setOncreateViewListener(OnCreateViewListner listner)
    {
        ocvl=listner;



    }


    public thirdfragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.

     * @return A new instance of fragment thirdfragment.
     */
    // TODO: Rename and change types and number of parameters
    public static thirdfragment newInstance(String param1) {
        Log.d(TAG, "newInstance: ");
        thirdfragment fragment = new thirdfragment();
        Bundle args = new Bundle();
        args.putString(tvDisplay, param1);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ocvl.onCreateViewCalled();
        Log.d(TAG, "onCreatefrag: ");
        if (getArguments() != null) {
            mParam1 = getArguments().getString(tvDisplay);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d(TAG, "onCreateView: ");
        View item= inflater.inflate(R.layout.fragment_thirdfragment, container, false);
        TextView tv_disp= (TextView)item.findViewById(R.id.text);
        tv_disp.setText(mParam1);
        ((com.example.test.lecture7.MainActivity)getActivity()).show_toast("created by gragment");
        return item;
    }

    public interface OnCreateViewListner
    {
         void onCreateViewCalled();

    }

}
