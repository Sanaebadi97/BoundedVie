package sanaebadi.info.boundedview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class BoundedView extends LinearLayout {

  private int mBoundedHeight, mBoundedWidth;

  public BoundedView(Context context) {
    super(context);
    mBoundedHeight = 0;
    mBoundedWidth = 0;
  }

  public BoundedView(Context context, AttributeSet attrs) {
    super(context, attrs);
    TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.BoundedView);
    mBoundedWidth = array.getDimensionPixelSize(R.styleable.BoundedView_boundedWidth, 0);
    mBoundedHeight = array.getDimensionPixelSize(R.styleable.BoundedView_boundedHeight, 0);
    array.recycle();
  }


  public void setmBoundedHeight(int height) {
    mBoundedHeight = height;
    requestLayout();
  }


  public void setmBoundedWidth(int width) {
    mBoundedWidth = width;
    requestLayout();
  }

  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

    int measureWidth = MeasureSpec.getSize(widthMeasureSpec);
    if (mBoundedWidth > 0 & mBoundedWidth < measureWidth) {
      int measureMode = MeasureSpec.getMode(widthMeasureSpec);
      widthMeasureSpec = MeasureSpec.makeMeasureSpec(mBoundedWidth, measureMode);
    }

    int measureHeight= MeasureSpec.getSize(heightMeasureSpec);
    if (mBoundedHeight > 0 & mBoundedHeight < measureHeight) {
      int measureMode = MeasureSpec.getMode(heightMeasureSpec);
      heightMeasureSpec = MeasureSpec.makeMeasureSpec(mBoundedHeight, measureMode);
    }


    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
  }
}
