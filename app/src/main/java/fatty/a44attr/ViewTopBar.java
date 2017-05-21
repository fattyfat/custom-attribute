package fatty.a44attr;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Fatty on 2017-02-10.
 */

public class ViewTopBar extends RelativeLayout {

    protected Button    mLeftButton,mRightButton;
    protected TextView  mTitleView;

    protected int       mLeftTextColor, mRightTextColor,mTitleTextColor;
    protected float     mTitleTextSize;
    protected Drawable  mLeftBackground,mRightBackground,mTitleBackground;
    protected String    mLeftText,mRightText,mTitle;
    protected LayoutParams mLeftParams,mRightParams,mTitleParams;
    protected topbarClickListener mListener;

    public ViewTopBar(Context context, AttributeSet attrs){

        super(context,attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs ,R.styleable.TopBar);

        mLeftTextColor = ta.getColor(R.styleable.TopBar_leftTextColor ,0);
        mLeftBackground = ta.getDrawable(R.styleable.TopBar_leftBackground);
        mLeftText = ta.getString(R.styleable.TopBar_leftText);

        mRightTextColor = ta.getColor(R.styleable.TopBar_rightTextColor ,0);
        mRightBackground = ta.getDrawable(R.styleable.TopBar_rightBackground);
        mRightText = ta.getString(R.styleable.TopBar_rightText);

        mTitleBackground = ta.getDrawable(R.styleable.TopBar_titleBackground);
        mTitleTextSize = ta.getDimension(R.styleable.TopBar_titleTextSize ,10);
        mTitleTextColor = ta.getColor(R.styleable.TopBar_titleTextColor ,0);
        mTitle = ta.getString(R.styleable.TopBar_title);

        ta.recycle();

        mLeftButton = new Button(context);
        mRightButton = new Button(context);
        mTitleView = new TextView(context);

        mLeftButton.setTextColor(mLeftTextColor);
        mLeftButton.setBackground(mLeftBackground);
        mLeftButton.setText(mLeftText);

        mRightButton.setTextColor(mRightTextColor);
        mRightButton.setBackground(mRightBackground);
        mRightButton.setText(mRightText);

        mTitleView.setText(mTitle);
        mTitleView.setTextColor(mTitleTextColor);
        mTitleView.setBackground(mTitleBackground);
        mTitleView.setTextSize(mTitleTextSize);
        mTitleView.setGravity(Gravity.CENTER);

        mLeftParams = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT);
        mLeftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);
        addView(mLeftButton,mLeftParams);

        mRightParams = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT);
        mRightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);
        addView(mRightButton,mRightParams);

        mTitleParams = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT);
        mTitleParams.addRule(RelativeLayout.CENTER_IN_PARENT,TRUE);
        addView(mTitleView,mTitleParams);

        mLeftButton.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v){
                mListener.leftClick();
            }
        });

        mRightButton.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                mListener.rightClick();
            }
        });

    }

    public void setOnTopbarClickListener(topbarClickListener mListener){
        this.mListener = mListener;
    }

    //抽象接口
    public interface topbarClickListener{

        void leftClick();
        void rightClick();
    }

    public void setButtonVisable(int id, boolean flag) {
        if (flag) {
            if (id == 0) {
                mLeftButton.setVisibility(View.VISIBLE);
            } else {
                mRightButton.setVisibility(View.VISIBLE);
            }
        } else {
            if (id == 0) {
                mLeftButton.setVisibility(View.GONE);
            } else {
                mRightButton.setVisibility(View.GONE);
            }
        }
    }
}
