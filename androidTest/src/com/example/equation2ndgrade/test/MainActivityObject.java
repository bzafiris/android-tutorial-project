package com.example.equation2ndgrade.test;

import android.content.Context;

import com.example.equation2ndgrade.R;

/**
 * Should be refactored to a real Activity Object.
 * Now it just contains utility methods
 * @author Vassilis Zafeiris
 *
 */
public class MainActivityObject {

	Context ctx;
	
	public MainActivityObject(Context ctx) {
		this.ctx = ctx;
	}
	
	public String formatRoot1Label(double root){
		
		StringBuffer buffer = new StringBuffer(ctx.getResources().getString(com.example.equation2ndgrade.R.string.label_root1));
		buffer.append(" ");
		buffer.append(Double.toString(root));
		return buffer.toString();
		
	}
	
	public String formatRoot2Label(double root){
		
		StringBuffer buffer = new StringBuffer(ctx.getResources().getString(com.example.equation2ndgrade.R.string.label_root2));
		buffer.append(" ");
		buffer.append(Double.toString(root));
		return buffer.toString();
		
	}
	
}