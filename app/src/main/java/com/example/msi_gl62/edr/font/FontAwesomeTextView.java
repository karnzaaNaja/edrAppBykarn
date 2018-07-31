package com.example.msi_gl62.edr.font;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class FontAwesomeTextView extends AppCompatTextView {

	private static Typeface sFontAwesomeIcons;

	public FontAwesomeTextView(Context context) {
		this(context, null);
	}

	public FontAwesomeTextView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public FontAwesomeTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		if (isInEditMode()) return;//Won't work in Eclipse graphical layout
		setTypeface();
	}
	private void setTypeface() {
		if (sFontAwesomeIcons == null) {
			sFontAwesomeIcons = Typeface.createFromAsset(getContext().getAssets(), "fonts/fontawesome-webfont.ttf");
		}
		setTypeface(sFontAwesomeIcons);
	}
}
