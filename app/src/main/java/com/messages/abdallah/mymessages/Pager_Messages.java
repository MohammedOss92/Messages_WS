package com.messages.abdallah.mymessages;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


import java.util.List;
import java.util.Locale;

import com.messages.abdallah.mymessages.Classes.Messages;
import com.messages.abdallah.mymessages.SqliteClasses.Sqlite;
import com.messages.abdallah.mymessages.Utils.Utils;

public class Pager_Messages extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;


    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;

    int titleID;
    List<Messages> myArrayList;
    String filter="";
    int msgId=0;
    int origPOS=0;
    int newMsg=0;
    boolean sourceISFav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager_messages);
        Intent i=getIntent();
        titleID=i.getExtras().getInt("titleID");
        int pos=i.getExtras().getInt("pos");
        filter=i.getExtras().getString("filter");
        msgId=i.getExtras().getInt("msgID");
        // in case of fav the origPos sent from FavMessages as favOrder
        // but in case of normal message it sent as origpos
        origPOS=i.getExtras().getInt("origPos");
        newMsg=i.getExtras().getInt("newMsg");
        sourceISFav=i.getExtras().getBoolean("sourceIsFav");

        Sqlite ss=new Sqlite(getApplicationContext());
        if(sourceISFav)
        {
            //we have to keep it ASC in Fav because of pager position
            //because we use its order while in normal messages it is not favorder but it is origposition
            myArrayList = ss.getFavMessagesOrderedASC() ;
        }

        else {
            myArrayList = ss.getMessagesNotOrdered(titleID);
        }
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        if(sourceISFav)
        //because order of fav start from index difference while normal messages start from ok index
        {mViewPager.setCurrentItem(origPOS-1);}
        else
        {mViewPager.setCurrentItem(origPOS);}


        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


//////////////////////////////////





        //   myArrayList=  ss.getMessages(titleID);
        //   mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        // mViewPager.setAdapter(mSectionsPagerAdapter);

    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_pager_messages, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).

            Messages m=(Messages) myArrayList.get(position);


            return PlaceholderFragment.newInstance(position + 1,m.getMsgDescription(),m.getNewMsg(), m);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.

            return myArrayList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.title_section1).toUpperCase(l);
                case 1:
                    return getString(R.string.title_section2).toUpperCase(l);
                case 2:
                    return getString(R.string.title_section3).toUpperCase(l);
            }
            return null;
        }

        @Override
        public int getItemPosition(Object object) {
            return super.getItemPosition(object);
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        private static final String ARG_MSG = "msg";
        int globalTextSize=12;

        String message;
        TextView tv;
        TextView tvTitle;
        RelativeLayout rl;

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */

        public static PlaceholderFragment newInstance(int sectionNumber, String msg, int newMsg , Messages m) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            args.putString("Resaleh", msg);
            args.putInt("newMsg", newMsg);
            //args.putParcelable("MsgObject", (Parcelable) m);
            args.putParcelable("MsgObject",  m);

//            Bundle bundle = new Bundle();
//            bundle.putSerializable("msgClass", (Serializable) m);
//            args.putBundle("msgClass",(Serializable) m);
            fragment.setArguments(args);



            return fragment;
        }

        public PlaceholderFragment()
        {

        }


        @Override
        public void onAttach(Activity activity) {
            // Toast.makeText(getActivity(),"AAA",Toast.LENGTH_SHORT).show();
            super.onAttach(activity);
        }




        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
        {

            View rootView = inflater.inflate(R.layout.fragment_pager__messages, container, false);
            //Toast.makeText(getActivity(),"BBB",Toast.LENGTH_SHORT).show();
            tv=(TextView) rootView.findViewById(R.id.tvMsg);
            tvTitle=(TextView) rootView.findViewById(R.id.tvTitle);
            rl=(RelativeLayout) rootView.findViewById(R.id.rl);
            SharedPreferences sp= PreferenceManager.getDefaultSharedPreferences(getActivity());
            int txtSize=sp.getInt("txtSize",18);
            globalTextSize=txtSize;
            tv.setTextSize(txtSize);


            ImageView img=(ImageView) rootView.findViewById(R.id.imgNew);
            String msg=getArguments().getString("Resaleh");
            int theNewMsg=getArguments().getInt("newMsg");
            final Messages m=getArguments().getParcelable("MsgObject");
            final Sqlite s=new Sqlite(getActivity());
            String titleDesc=s.getMsgTitleByTitleID(m.getTypeId());
            tvTitle.setText(titleDesc);
            // Toast.makeText(getActivity(),m.getMsgID()+"",Toast.LENGTH_SHORT).show();
            if(theNewMsg==0)
            {
                img.setVisibility(View.INVISIBLE);
            }
            else
            {
                img.setVisibility(View.VISIBLE);
            }
            tv.setText(msg);


            //////////////////////////

            final ImageView imgFav=(ImageView) rootView.findViewById(R.id.imgFav);
            if(s.getIFMsgIsFav(m)==1)
            {
                imgFav.setBackgroundResource(R.drawable.thisfavorite);
            }
            else
            {
                imgFav.setBackgroundResource(R.drawable.notfavorite);
            }

            imgFav.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(s.getIFMsgIsFav(m)==0) {
                        imgFav.setBackgroundResource(R.drawable.thisfavorite);
                        s.changeFav( m,1);

                    }
                    else
                    {  imgFav.setBackgroundResource(R.drawable.notfavorite);
                        s.changeFav(m, 0);






                    }
                }
            });


            /////////////////////////



            return rootView;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            // TODO Auto-generated method stub
            super.onCreate(savedInstanceState);
            this.setHasOptionsMenu(true);
        }

        @Override
        public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
            // TODO Auto-generated method stub
            Log.i("FragCreateList","onCreateOptionsMenu called");
            inflater.inflate(R.menu.menu_pager_messages, menu);

            super.onCreateOptionsMenu(menu, inflater);
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {

            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_share) {
                Utils.IntenteShare(getActivity(), "مسجاتي", "مسجاتي", tv.getText().toString());
                return true;
            }
///////////////////
            else if(id==R.id.action_edit)
            {
                Intent i = new Intent(getActivity(),ActivityText.class);

                String data = tv.getText().toString();
                i.putExtra("na",tv.getText().toString());

                startActivity(i);
            }
            ///////////////////
            else if (id==R.id.action_copy)
            {
                String stringYouExtracted = tv.getText().toString();
                if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.HONEYCOMB) {
                    android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                    clipboard.setText(stringYouExtracted);
                }
                else {
                    android.content.ClipboardManager clipboard = (android.content.ClipboardManager)getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                    android.content.ClipData clip = android.content.ClipData
                            .newPlainText(stringYouExtracted, stringYouExtracted);
                    clipboard.setPrimaryClip(clip);
                }
                Toast.makeText(getActivity(), "تم نسخ النص", Toast.LENGTH_SHORT).show();
            }
////////////////////////
            else if(id==R.id.action_text_size)
            {
                SeekBar();
            }

/////////////////////////

//            else if (id==R.id.action_background_color)
//            {
//                RadioButtonDialog();
//            }
            ////////////////////////////////////

            else if(id==R.id.action_fav)
            {

            }


            return super.onOptionsItemSelected(item);
        }


        //////////////////////////////

        private void RadioButtonDialog() {
            // custom dialog
            final Dialog dialog = new Dialog(getActivity());
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.dialog_design);
            dialog.setTitle("تغيير اللون");
            RadioGroup rg = (RadioGroup) dialog.findViewById(R.id.radio_group);
            final RadioButton light =(RadioButton)dialog.findViewById(R.id.light);
            RadioButton dark =(RadioButton)dialog.findViewById(R.id.dark);

            light.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rl.setBackgroundColor(Color.WHITE);

                }
            });

            dark.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rl.setBackgroundColor(Color.BLACK);
                    tv.setTextColor(Color.WHITE);
                }
            });


            dialog.show();
        }


        /////////////////////////////////////////////////

        private void SeekBar() {
            final AlertDialog.Builder popDialog = new AlertDialog.Builder(getActivity());

            final SeekBar seek = new SeekBar(getActivity());

            seek.setMax(100);
            seek.setProgress(globalTextSize);
            seek.refreshDrawableState();
            popDialog.setTitle("حجم الخط");

            popDialog.setView(seek);
            seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                    globalTextSize=progress;
                    tv.setTextSize(progress);

                    SharedPreferences sp= PreferenceManager.getDefaultSharedPreferences(getActivity());
                    SharedPreferences.Editor et=sp.edit();
                    et.putInt("txtSize",progress);
                    et.commit();

                }
                public void onStartTrackingTouch(SeekBar arg0) {

                }
                public void onStopTrackingTouch(SeekBar seekBar) {


                }
            });
//// Button OK
//            popDialog.setPositiveButton("تم", new DialogInterface.OnClickListener() {
//
//                public void onClick(DialogInterface dialog, int which) {
//                    dialog.dismiss();
//                }
//            });

            popDialog.create();

            popDialog.show();






        }
        ////////////////////////////////////
    }

}
