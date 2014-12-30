package com.example.mateusz.insurancedb;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Details extends Activity {


    private static class DetailListAdapter extends ArrayAdapter<String> {

        Context context;
        List<String> objects;

        static class ViewHolder {
            private TextView elementText;
        }

        DetailListAdapter(Context context, int resource, List<String> objects) {
            super(context, resource, objects);
            this.objects = objects;
            this.context = context;
        }

        @Override
        public int getCount() {
            return objects.size();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = new ViewHolder();
            if (convertView == null) {
                LayoutInflater mInflater = (LayoutInflater) context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = mInflater.inflate(R.layout.simple_list_edittext_item, parent, false);
                holder.elementText = (TextView) convertView.findViewById(R.id.details_item_textview);
                convertView.setTag(holder);

            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.elementText.setText(objects.get(position));

            return convertView;
        }




    }

    ArrayList<mTab> mTabs = new ArrayList<mTab>();
    ViewPager mViewPager;
    SlidingTabLayout mSlidingTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mTabs.add(new mTab(
                "Oc",
                "1"
        ));
        mTabs.add(new mTab(
                "Smochody",
                "2"
        ));
        mTabs.add(new mTab(
                "Kontakty",
                "3"
        ));
        mTabs.add(new mTab(
                "Dziwki",
                "4"
        ));
        setContentView(R.layout.activity_details);
    }
    @Override
    protected void onStart() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(new SimplePagerAdapter());
        mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
        mSlidingTabLayout.setViewPager(mViewPager);

        super.onStart();
    }
    static class mTab {
        private final String mTitle;
        private final String mText;

        mTab(String title, String text) {
            mTitle = title;
            mText = text;
        }
    }
    class SimplePagerAdapter extends PagerAdapter{
        ArrayList<String> lista = new ArrayList<>();

        DetailListAdapter detailListAdapter =new DetailListAdapter(getApplicationContext(), R.id.details_item_textview, lista);
        @Override
        public int getCount() {
            return mTabs.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return object == view;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTabs.get(position).mTitle;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        public Object instantiateItem(ViewGroup container, int position) {
            // Inflate a new layout from our resources
            View view = getLayoutInflater().inflate(R.layout.pager_item,
                    container, false);
            // Add the newly created View to the ViewPager
            lista.add("asd");
            lista.add("asd");
            lista.add("asd");
            container.addView(view);
            ListView detailsList = (ListView) findViewById(R.id.details_list_container);

            detailsList.setAdapter(detailListAdapter);


            // Retrieve a TextView from the inflated View, and update it's text

            // Return the View
            return view;
        }
    }
}
