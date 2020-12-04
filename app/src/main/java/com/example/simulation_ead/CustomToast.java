package com.example.simulation_ead;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.simulation_ead.R;

public class CustomToast extends Toast {

    private static TextView toastText;
    private static ImageView toastImage;

    private static ImageView toast_image_new_event_1;
    private static ImageView toast_image_new_event_2;
    private static ImageView toast_image_new_event_3;

    private static TextView brain_add;
    private static TextView heart_add;
    private static TextView smile_add;



    private View rootView;

    public CustomToast(Context context, int indicator) {
        super(context);
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (indicator==1) {
            rootView = inflater.inflate(R.layout.custome_toast, null);
            toastImage = (ImageView) rootView.findViewById(R.id.imageView1);
            toastText = (TextView) rootView.findViewById(R.id.textView1);
        }
        if (indicator==2){
            rootView = inflater.inflate(R.layout.custome_lvl_toast, null);
            toast_image_new_event_1 = (ImageView) rootView.findViewById(R.id.image_new_event_1);
            toast_image_new_event_2 = (ImageView) rootView.findViewById(R.id.image_new_event_2);
            toast_image_new_event_3 = (ImageView) rootView.findViewById(R.id.image_new_event_3);
            toastText = (TextView) rootView.findViewById(R.id.textView1);
        }
        if (indicator==3){
            rootView = inflater.inflate(R.layout.reklam_custom_toast, null);
            brain_add = (TextView) rootView.findViewById(R.id.brain_add);
            heart_add = (TextView) rootView.findViewById(R.id.heart_add);
            smile_add = (TextView) rootView.findViewById(R.id.smile_add);
        }

        this.setView(rootView);
        this.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 0);
        this.setDuration(Toast.LENGTH_SHORT);
    }





    /*
     * Метод вызова сообщения с установкой длительности существования и
     * с передачей сообщению текстовой информации в качестве последовательности
     * текстовых символов или строки
     */
    public static CustomToast makeText(Context context, CharSequence text, int duration, int indicator, int image) {

            CustomToast result = new CustomToast(context, indicator);
            result.setDuration(duration);
            toastText.setText(text);
            toastImage.setImageResource(image);
            return result;

    }

    public static CustomToast makeText(Context context, CharSequence text, int duration, int indicator, int [] image_mas) {
        CustomToast result = new CustomToast(context, indicator);
        result.setDuration(duration);
        toastText.setText(text);
        toast_image_new_event_1.setImageResource(image_mas[0]);
        toast_image_new_event_2.setImageResource(image_mas[1]);
        toast_image_new_event_3.setImageResource(image_mas[2]);
        return result;
    }


    /*
     * Метод вызова сообщения с установкой длительности существования и
     * с передачей сообщению ID текстового ресурса
     */
    public static Toast makeText(Context context, int duration, int indicator){
        CustomToast result = new CustomToast(context, indicator);
        result.setDuration(duration);
        brain_add.setText(Integer.toString((int) FriendsActivity.getRandomNumber(50, 20)));
        heart_add.setText(Integer.toString((int) FriendsActivity.getRandomNumber(50, 20)));
        smile_add.setText(Integer.toString((int) FriendsActivity.getRandomNumber(50, 20)));
        return result;
    }

}
