package rtc.papatsara.oiltraffic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by SmilecomputeR on 16/10/2559.
 */


public class TrafficAdapter extends BaseAdapter{

    //Explicit
    private Context context;    //ท่อที่ใช้ส่งข้อมูล
    private String[] titleStrings, detailStrings;
    private int[] ints;
    private TextView titleTextView, detailTextView;
    private ImageView imageView;

    public TrafficAdapter(Context context, String[] titleStrings, String[] detailStrings, int[] ints) {
        this.context = context;
        this.titleStrings = titleStrings;
        this.detailStrings = detailStrings;
        this.ints = ints;
    }

    @Override
    public int getCount() {
        return titleStrings.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.traffic_listviview, parent, false);

        //Bind Widget
        titleTextView = (TextView) view.findViewById(R.id.textView2);
        detailTextView = (TextView) view.findViewById(R.id.textView3);
        imageView = (ImageView) view.findViewById(R.id.imageView);

        //Show View
        titleTextView.setText(titleStrings[position]);

        //กาาตัดคำโดยจะแสดงแค่ 30 ตัวอักษรเท่านั้น แต่ถ้าน้อยกว่า
        //30 ตัวอักษร ให้แสดงทั้งหมด

        if (detailStrings[position].length() <= 30) {
        //รายละเอียดน้อยกว่า 30 ตัวอักษร
            detailTextView.setText(detailStrings[position]);
        } else {
            //นี่คือมากกว่า 30 ตัวอักษร
            detailTextView.setText(detailStrings[position].substring(0,30 )+ "...");
        }


        return view;
    }
}   // Main Class
