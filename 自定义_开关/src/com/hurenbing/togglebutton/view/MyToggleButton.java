package com.hurenbing.togglebutton.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MyToggleButton extends View {

	private int slideBackgroundWidth;
	private int slideBackgroundHeight;
	private int slideIconWidth;
	private int slideIconHeight;
	private int slideIconMaxLeft;
	private Bitmap slideBackground;
	private Bitmap slideIcon;
	private float left;

	public MyToggleButton(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	/**�����¼�*/
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			left=event.getX()-slideIconWidth/2;
			break;
		case MotionEvent.ACTION_MOVE:
			left=event.getX()-slideIconWidth/2;
			break;
		case MotionEvent.ACTION_UP:
			if (event.getX() < slideBackgroundWidth / 2) {
				left = 0;
			} else {
				left = slideIconMaxLeft;
			}
			break;
		default:
			break;
		}
		invalidate();
		return true;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawBitmap(slideBackground, 0, 0, null);
		if (left < 0) {
			left = 0;
		} else if (left > slideIconMaxLeft) {
			left = slideIconMaxLeft;
		}
		canvas.drawBitmap(slideIcon, left, 0, null);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		setMeasuredDimension(slideBackgroundWidth, slideBackgroundHeight);
	}
	
	/**���ÿ��صı���ͼƬ�������ذ�ť,�����������ǵĳߴ�*/
	public void setSlideBackground(int slideBackgroundId, int slideIconId) {
		slideBackground = BitmapFactory.decodeResource(getResources(),
				slideBackgroundId);
		slideIcon = BitmapFactory.decodeResource(getResources(), slideIconId);
		slideBackgroundWidth = slideBackground.getWidth();
		slideBackgroundHeight = slideBackground.getHeight();

		slideIconWidth = slideIcon.getWidth();
		slideIconHeight = slideIcon.getHeight();

		slideIconMaxLeft = slideBackgroundWidth - slideIconWidth;
	}
	
	/**���ÿ��ص�״̬*/
	public void setState(boolean state) {
		if(state){
			left=slideIconMaxLeft;
		}else{
			left=0;
		}
		invalidate();
	}
	
	/**
	 * �õ����ص�״̬��true�ǿ�
	 * @return
	 */
	public boolean getState(){
		if(left==0){
			return false;
		}
		return true;
	}

}
