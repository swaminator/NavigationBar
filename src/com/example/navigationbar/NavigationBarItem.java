package com.example.navigationbar;



import android.content.Context;
import android.location.GpsStatus.Listener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewDebug.ExportedProperty;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class NavigationBarItem extends FrameLayout implements View.OnClickListener {

    private Button mButton;

    public NavigationBarItem(Context context) {
        super(context);
        Log.e("HOLA","NBI Context");
        init(context, null, -1);
    }
    public NavigationBarItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, -1);
    }

    public NavigationBarItem(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs, defStyle);
    }

    private void init(Context context, AttributeSet attrs, int defStyle) {
        Log.d("HOLA","init:NBI");
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.navigation_bar_item, this);
        mButton = (Button) findViewById(R.id.navigation_bar_item_button);
        mButton.setGravity(Gravity.CENTER);
        mButton.setText("Sample");
//        mButton.setOnClickListener(this);
    }
    
    public void setText(CharSequence text) {
        mButton.setText(text);
    }

    public CharSequence getText() {
        return mButton.getText();
    }
    
    @Override
    public void setActivated(boolean activated) {
        Log.d("HOLA", "setAcivated:"+activated);
        super.setActivated(activated);
        if(activated) {
        mButton.setActivated(activated);
        }
    }
    
    @Override
    public boolean isActivated() {
        // TODO Auto-generated method stub
        return super.isActivated();
        
    }
    
    public boolean isEnabled() {
        return mButton.isEnabled();
    }
    
    @Override
    public void setEnabled(boolean enabled) {
        mButton.setEnabled(enabled);
    }
    
    @Override
    public boolean isSelected() {
        return mButton.isSelected();
    }
    
    @Override
    public void setSelected(boolean selected) {
        mButton.setSelected(selected);
    }
    
    @Override
    public void setOnClickListener(OnClickListener l) {
        // TODO Auto-generated method stub
        super.setOnClickListener(l);
        mButton.setOnClickListener(l);
    }
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        Log.d("HOLA","onClick Button:"+mButton+" View:"+v);
        if(mButton.isActivated()) return;
        else setActivated(true);
    }
    
    public Button getButton() {
        return mButton;
    }
//    public void setOnNavigationBarItemActivated(NavigationBarItemOnActivatedListener listener) {
//        mNBIOnActivatedListener = listener;
//    }
//    @Override
//    public void setOnClickListener(OnClickListener l) {
//        Log.e("HOLA", "Onclick()");
////        mButton.setOnClickListener(this);
//    }
//    @Override
//    public void onClick(View v) {
//        // TODO Auto-generated method stub
//        Log.d("HOLA", "Onclick()-------------");
//        if(mButton.isActivated()){
//            return;
//        } else {
//           mButton.setActivated(true);
//        }
//    }
}
