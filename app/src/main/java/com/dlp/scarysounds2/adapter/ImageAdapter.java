package com.dlp.scarysounds2.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.dlp.scarysounds2.R;

public class ImageAdapter extends BaseAdapter {
	private Context context;
	private final int[] fotos;
    int params = 0;
	private final int[] sons;

	public ImageAdapter(Context context, int[] fotos, int params, int[] sons ) {
		this.context = context;
		this.fotos = fotos;
		this.params = params;
		this.sons = sons;
	}

	public int getCount() {
		return fotos.length;
	}

	@Override
	public Object getItem(int position) {

		return position;
	}

	@Override
	public long getItemId(int position) {

		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View grid;

		if (convertView==null){
			LayoutInflater inflater = LayoutInflater.from(context);//(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			grid = inflater.inflate(R.layout.grid_single, null);
		}else {
			grid = convertView;
		}
        //Log.i("Position Adapter:", "" + position);
        ImageView imagem = (ImageView)grid.findViewById(R.id.grid_image);
		TextView texto = (TextView)grid.findViewById(R.id.grid_text);
		Resources res = context.getResources();
		texto.setText(soundName(res.getResourceEntryName(sons[position])));
		FrameLayout.LayoutParams rlParams =  new FrameLayout.LayoutParams(params, params);

		imagem.setImageResource(fotos[0]);
		imagem.setAdjustViewBounds(true);
		imagem.setLayoutParams(rlParams);
		return grid;

	}

	public String soundName(String entry){
		StringBuffer res = new StringBuffer();

		String[] strArr = entry.split("_");
		for (String str : strArr) {
			char[] stringArray = str.trim().toCharArray();
			stringArray[0] = Character.toUpperCase(stringArray[0]);
			str = new String(stringArray);

			res.append(str).append(" ");
		}
		return res.toString();
	}

}