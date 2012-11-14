
package com.example.navigationbar;

import java.util.ArrayList;


import android.content.Context;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/**
 * <code>NavigationBar</code> is a specific implementation of {@link TopBar} for
 * <em>Master Content</em>.
 * <p>
 * <img src="doc-files/Bars-UXDF-5.3.3.4.png">
 * <p>
 * 
 * @version 1.7
 * @since 1.7
 * @author brldmila
 */
public class NavigationBar extends LinearLayout implements View.OnClickListener{

    private static final String TAG = "NavigationBar";
    private static final boolean DEBUG = true;
    
    private NavigationBarItem[] mNavBarItems;
    private NavigationBarItem mActivatedItem;
    private int mCount = 0;
    public NavigationBar(Context context) {
        super(context); Log.e("HOLA", "NavigationBar(Context context)");
        init(context, null, -1);
    }

    public NavigationBar(Context context, AttributeSet attrs) {
        super(context, attrs); Log.e("HOLA", "NavigationBar(Context context, Attrset)");
        init(context, attrs, -1);
    }

    public NavigationBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle); Log.e("HOLA", "NavigationBar(Context context, attrs, defstyle)");
        init(context, attrs, defStyle);
    }

    private void init(Context context, AttributeSet attrs, int defStyle) {
        Log.e("HOLA", "init");
        setOrientation(LinearLayout.HORIZONTAL);
        mNavBarItems = new NavigationBarItem[3];
        if (DEBUG) {
            addItem("Item 1");
            addItem("Item 2");
            addItem("3");
        }
        for(int i=0;i<mNavBarItems.length;i++){
            mNavBarItems[i].setOnClickListener(this);
        }
    }

    public void setNavigationBarItemText(CharSequence text, int position) {
        NavigationBarItem nv = mNavBarItems[position];
        if (nv!=null) nv.setText(text);
    }
    
    public CharSequence getNavigationBarItemText(int position) {
        NavigationBarItem nv = mNavBarItems[position];
        if(nv!=null) return nv.getText();
        else return null;
    }
    
    public boolean isNavigationBarItemEnabled(int position) {
        NavigationBarItem nv = mNavBarItems[position];
        if(nv!=null) return nv.isEnabled();
        else return false;
    }
    
    public void setNavigationBarItemActivated(NavigationBarItem nv, boolean activated) {
        if(nv!=null) {
            if(nv.isActivated())
                return;
            else {
                for (NavigationBarItem n: mNavBarItems) {
                    n.setActivated(false);
                }
                nv.setActivated(true);
                mActivatedItem = nv;
            }
        }
    }
    /*
     * (non-Javadoc)
     * @see android.view.ViewGroup#addView(android.view.View, int, int)
     */
    @Override
    public void addView(View child, int width, int height) {
        Log.e("HOLA", "addView(View child, int width, int height)");
        checkChild(child);
        super.addView(child, width, height);
    }

    /*
     * (non-Javadoc)
     * @see android.view.ViewGroup#addView(android.view.View, int,
     * android.view.ViewGroup.LayoutParams)
     */
    @Override
    public void addView(View child, int index, android.view.ViewGroup.LayoutParams params) {
        Log.e("HOLA", "addView(View child, int index, layoutparams)");
        checkChild(child);
        super.addView(child, index, params);
    }

    /*
     * (non-Javadoc)
     * @see android.view.ViewGroup#addView(android.view.View, int)
     */
    @Override
    public void addView(View child, int index) {
        Log.e("HOLA", "addView(View child, int index)");
        checkChild(child);
        super.addView(child, index);
    }

    /*
     * (non-Javadoc)
     * @see android.view.ViewGroup#addView(android.view.View, android.view.ViewGroup.LayoutParams)
     */
    @Override
    public void addView(View child, android.view.ViewGroup.LayoutParams params) {
        Log.e("HOLA", "addView(View child, layoutparams)");
        checkChild(child);
        super.addView(child, params);
    }

    /*
     * (non-Javadoc)
     * @see android.view.ViewGroup#addView(android.view.View)
     */
    @Override
    public void addView(View child) {
        Log.e("HOLA", "addView(View child");
        checkChild(child);
        super.addView(child);
    }

    /*
     * (non-Javadoc)
     * @see android.view.ViewGroup#addViewInLayout(android.view.View, int,
     * android.view.ViewGroup.LayoutParams, boolean)
     */
    @Override
    protected boolean addViewInLayout(View child, int index,
            android.view.ViewGroup.LayoutParams params, boolean preventRequestLayout) {
        Log.e("HOLA", "addViewinLayout1");
        checkChild(child);
        return super.addViewInLayout(child, index, params, preventRequestLayout);
    }

    /*
     * (non-Javadoc)
     * @see android.view.ViewGroup#addViewInLayout(android.view.View, int,
     * android.view.ViewGroup.LayoutParams)
     */
    @Override
    protected boolean addViewInLayout(View child, int index,
            android.view.ViewGroup.LayoutParams params) {
        Log.e("HOLA", "addViewinLayout2");
        checkChild(child);
        return super.addViewInLayout(child, index, params);
    }

    /**
     * Checks the child being added by any of the <em>addView()</em> methods.
     * 
     * @param child the child
     */
    private void checkChild(View child) {
        Log.e("HOLA", "checkChild");
        if (!(child instanceof NavigationBarItem)) {
            throw new RuntimeException(
                    "NavigationBar only accepts NavigationBarItems as children. Trying to add "
                            + child);
        }
    }

    /**
     * Adds a new {@link NavigationBarItem} to this <em>Navigation Bar</em>.
     * 
     * @param text label for the {@link NavigationBarItem}
     */
    public NavigationBarItem addItem(CharSequence text) {
        Log.e("HOLA", "addItem");
        if (DEBUG) Log.d(TAG, "addItem(" + text + ")");
        final NavigationBarItem nvi = new NavigationBarItem(getContext());
        nvi.setText(text);
        nvi.setClickable(true);
        nvi.setFocusable(true);
        Log.e("HOLA", "setOnClickListener"+this+" nvi:"+nvi);
        nvi.setOnClickListener(this);
        mNavBarItems[mCount] = nvi;
        mCount++;
        addView(nvi);
        return nvi;
    }
    
    private NavigationBarItem getItem(View v) {
        for(NavigationBarItem n: mNavBarItems){
            if(n.getButton().equals(v))
                return n;
        }
        return null;
    }
  
    @Override
    public void onClick(View v) {
        Log.d("HOLA","NB:onCLick View:"+v);
        NavigationBarItem nv = getItem(v);
        if(nv!=null) {
            Log.d("HOLA","NB:setNBIActivated:"+nv+" isActivated="+nv.isActivated());
            setNavigationBarItemActivated(nv, nv.isActivated());
        }
    }
}
