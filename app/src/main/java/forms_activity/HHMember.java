
 package forms_activity;


 import android.annotation.SuppressLint;
 import java.util.ArrayList;
 import java.util.Calendar;
 import java.util.HashMap;
 import java.util.List;
 import android.app.*;
 import android.app.AlertDialog;
 import android.app.DatePickerDialog;
 import android.app.Dialog;
 import android.app.TimePickerDialog;
 import android.content.DialogInterface;
 import android.content.Intent;
 import android.location.Location;
 import android.view.KeyEvent;
 import android.os.Bundle;
 import android.view.View;
 import android.view.MotionEvent;
 import android.widget.AdapterView;
 import android.widget.Button;
 import android.widget.CheckBox;
 import android.widget.DatePicker;
 import android.widget.EditText;
 import android.widget.ImageButton;
 import android.widget.LinearLayout;
 import android.widget.RadioButton;
 import android.widget.RadioGroup;
 import android.widget.SimpleAdapter;
 import android.widget.Spinner;
 import android.widget.TextView;
 import android.widget.TimePicker;
 import android.widget.ArrayAdapter;
 import android.graphics.Color;
 import android.view.WindowManager;
 import androidx.constraintlayout.widget.ConstraintLayout;
 import android.widget.AutoCompleteTextView;
 import androidx.appcompat.app.AppCompatActivity;
 import androidx.core.content.ContextCompat;
 import forms_datamodel.HHMember_DataModel;
 import Utility.*;
 import Common.*;
 import android.widget.Toast;
 import android.text.TextWatcher;
 import android.widget.CompoundButton;
 import android.text.Editable;

 import org.icddrb.mental_health_survey.R;
 import org.icddrb.mental_health_survey.adapter.CustomSpinnerAdapter;

 public class HHMember extends AppCompatActivity {
    //Disabled Back/Home key
    //--------------------------------------------------------------------------------------------------
    @Override 
    public boolean onKeyDown(int iKeyCode, KeyEvent event)
    {
        if(iKeyCode == KeyEvent.KEYCODE_BACK || iKeyCode == KeyEvent.KEYCODE_HOME) 
             { return false; }
        else { return true;  }
    }

    boolean networkAvailable=false;
    Location currentLocation; 
    double currentLatitude,currentLongitude; 
    String VariableID;
    private int hour;
    private int minute;
    private int mDay;
    private int mMonth;
    private int mYear;
    static final int DATE_DIALOG = 1;
    static final int TIME_DIALOG = 2;

    Connection C;
    Global g;
    SimpleAdapter dataAdapter;
    ArrayList<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>();
    TextView lblHeading;
    LinearLayout secMEMID;
    View lineMEMID;
    TextView lblMEMID;
    TextView VlblMEMID;
    EditText txtMEMID;
    LinearLayout secVillID;
    View lineVillID;
    TextView lblVillID;
    TextView VlblVillID;
    EditText txtVillID;
    LinearLayout secHHID;
    View lineHHID;
    TextView lblHHID;
    TextView VlblHHID;
    EditText txtHHID;
    LinearLayout secMSlNo;
    View lineMSlNo;
    TextView lblMSlNo;
    TextView VlblMSlNo;
    EditText txtMSlNo;
    LinearLayout seclbl7;
    View linelbl7;
    LinearLayout secName;
    View lineName;
    TextView lblName;
    TextView VlblName;
    EditText txtName;
    LinearLayout secRth;
    View lineRth;
    TextView lblRth;
    TextView VlblRth;
    Spinner spnRth;
    LinearLayout secRth_oth;
    View lineRth_oth;
    TextView lblRth_oth;
    TextView VlblRth_oth;
    AutoCompleteTextView txtRth_oth;
    LinearLayout secSex;
    View lineSex;
    TextView lblSex;
    TextView VlblSex;
    RadioGroup rdogrpSex;
    RadioButton rdoSex1;
    RadioButton rdoSex2;
    RadioButton rdoSex3;
    LinearLayout secStayHH;
    View lineStayHH;
    TextView lblStayHH;
    TextView VlblStayHH;
    RadioGroup rdogrpStayHH;
    RadioButton rdoStayHH1;
    RadioButton rdoStayHH2;
    LinearLayout secStayLastNight;
    View lineStayLastNight;
    TextView lblStayLastNight;
    TextView VlblStayLastNight;
    RadioGroup rdogrpStayLastNight;
    RadioButton rdoStayLastNight1;
    RadioButton rdoStayLastNight2;
    LinearLayout secDOB;
    View lineDOB;
    TextView lblDOB;
    TextView VlblDOB;
    EditText txtDOB;
    LinearLayout secDOBDk;
    View lineDOBDk;
    TextView lblDOBDk;
    TextView VlblDOBDk;
    CheckBox chkDOBDk;
    LinearLayout secAgeY;
    View lineAgeY;
    TextView lblAgeY;
    TextView VlblAgeY;
    EditText txtAgeY;
    LinearLayout secMStatus;
    View lineMStatus;
    TextView lblMStatus;
    TextView VlblMStatus;
    RadioGroup rdogrpMStatus;
    RadioButton rdoMStatus1;
    RadioButton rdoMStatus2;
    RadioButton rdoMStatus3;
    RadioButton rdoMStatus4;
    LinearLayout secAttendSchool;
    View lineAttendSchool;
    TextView lblAttendSchool;
    TextView VlblAttendSchool;
    RadioGroup rdogrpAttendSchool;
    RadioButton rdoAttendSchool1;
    RadioButton rdoAttendSchool2;
    LinearLayout secSchoolLevel;
    View lineSchoolLevel;
    TextView lblSchoolLevel;
    TextView VlblSchoolLevel;
    RadioGroup rdogrpSchoolLevel;
    RadioButton rdoSchoolLevel1;
    RadioButton rdoSchoolLevel2;
    RadioButton rdoSchoolLevel3;
    RadioButton rdoSchoolLevel4;
    RadioButton rdoSchoolLevel5;
    LinearLayout secHighestClass;
    View lineHighestClass;
    TextView lblHighestClass;
    TextView VlblHighestClass;
    EditText txtHighestClass;
    LinearLayout secWorkStatus;
    View lineWorkStatus;
    TextView lblWorkStatus;
    TextView VlblWorkStatus;
    RadioGroup rdogrpWorkStatus;
    RadioButton rdoWorkStatus1;
    RadioButton rdoWorkStatus2;
    LinearLayout secHaveBRID;
    View lineHaveBRID;
    TextView lblHaveBRID;
    TextView VlblHaveBRID;
    RadioGroup rdogrpHaveBRID;
    RadioButton rdoHaveBRID1;
    RadioButton rdoHaveBRID2;
    RadioButton rdoHaveBRID3;
    RadioButton rdoHaveBRID4;
    LinearLayout secHaveNID;
    View lineHaveNID;
    TextView lblHaveNID;
    TextView VlblHaveNID;
    RadioGroup rdogrpHaveNID;
    RadioButton rdoHaveNID1;
    RadioButton rdoHaveNID2;
    RadioButton rdoHaveNID3;
    LinearLayout secHaveMobile;
    View lineHaveMobile;
    TextView lblHaveMobile;
    TextView VlblHaveMobile;
    RadioGroup rdogrpHaveMobile;
    RadioButton rdoHaveMobile1;
    RadioButton rdoHaveMobile2;
    LinearLayout secMoNo;
    View lineMoNo;
    TextView lblMoNo;
    TextView VlblMoNo;
    Spinner spnMoNo;
    LinearLayout secFaNo;
    View lineFaNo;
    TextView lblFaNo;
    TextView VlblFaNo;
    Spinner spnFaNo;
    LinearLayout secCurPreg;
    View lineCurPreg;
    TextView lblCurPreg;
    TextView VlblCurPreg;
    RadioGroup rdogrpCurPreg;
    RadioButton rdoCurPreg1;
    RadioButton rdoCurPreg2;
    RadioButton rdoCurPreg3;

    static int MODULEID   = 0;
    static int LANGUAGEID = 0;
    static String TableName;

    static String STARTTIME = "";
    static String DEVICEID  = "";
    static String ENTRYUSER = "";
    MySharedPreferences sp;

    Bundle IDbundle;
    static String MEMID = "";

 @SuppressLint("ClickableViewAccessibility")
 public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
   try
     {
         setContentView(R.layout.hhmember);
         getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

         C = new Connection(this);
         g = Global.getInstance();

         STARTTIME = g.CurrentTime24();
         DEVICEID  = MySharedPreferences.getValue(this, "deviceid");
         ENTRYUSER = MySharedPreferences.getValue(this, "userid");

         IDbundle = getIntent().getExtras();
         MEMID = IDbundle.getString("MEMID");

         TableName = "HHMember";
         MODULEID = 1;
         LANGUAGEID = Integer.parseInt(MySharedPreferences.getValue(this, "languageid"));
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(HHMember.this);
                 adb.setTitle("Close");

                 adb.setMessage("Do you want to close this form[Yes/No]?");
                 adb.setNegativeButton("No", null);
                 adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                     public void onClick(DialogInterface dialog, int which) {
                         finish();
                     }});
                 adb.show();
             }});

        Initialization();
        Connection.LocalizeLanguage(HHMember.this, MODULEID, LANGUAGEID);


         txtDOB.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                      VariableID = "btnDOB"; showDialog(DATE_DIALOG);
                      return true;
                 }
                 return false;
             }
         });



         //Hide all skip variables
         secRth_oth.setVisibility(View.GONE);
         lineRth_oth.setVisibility(View.GONE);
         secRth_oth.setVisibility(View.GONE);
         lineRth_oth.setVisibility(View.GONE);
         secSchoolLevel.setVisibility(View.GONE);
         lineSchoolLevel.setVisibility(View.GONE);
         secHighestClass.setVisibility(View.GONE);
         lineHighestClass.setVisibility(View.GONE);
         secHighestClass.setVisibility(View.GONE);
         lineHighestClass.setVisibility(View.GONE);


        DataSearch(MEMID);


        Button cmdSave = (Button) findViewById(R.id.cmdSave);
        cmdSave.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) { 
            DataSave();
        }});


     }
     catch(Exception  e)
     {
         Connection.MessageBox(HHMember.this, e.getMessage());
         return;
     }
 }

 @SuppressLint("ClickableViewAccessibility")
 private void Initialization()
 {
   try
     {
         secMEMID = (LinearLayout) findViewById(R.id.secMEMID);
         lineMEMID = (View) findViewById(R.id.lineMEMID);
         lblMEMID = (TextView) findViewById(R.id.lblMEMID);
         VlblMEMID = (TextView)  findViewById(R.id.VlblMEMID);
         txtMEMID = (EditText) findViewById(R.id.txtMEMID);
/* if (MEMID.length() == 0) txtMEMID.setText(Global.Get_UUID());
 else txtMEMID.setText(MEMID);
 txtMEMID.setEnabled(false);
 secMEMID.setVisibility(View.GONE);*/
         secVillID = (LinearLayout) findViewById(R.id.secVillID);
         lineVillID = (View) findViewById(R.id.lineVillID);
         lblVillID = (TextView)  findViewById(R.id.lblVillID);
         VlblVillID = (TextView)   findViewById(R.id.VlblVillID);
         txtVillID = (EditText) findViewById(R.id.txtVillID);
         secHHID = (LinearLayout) findViewById(R.id.secHHID);
         lineHHID = (View)findViewById(R.id.lineHHID);
         lblHHID = (TextView) findViewById(R.id.lblHHID);
         VlblHHID = (TextView)  findViewById(R.id.VlblHHID);
         txtHHID = (EditText) findViewById(R.id.txtHHID);
         secMSlNo = (LinearLayout) findViewById(R.id.secMSlNo);
         lineMSlNo = (View) findViewById(R.id.lineMSlNo);
         lblMSlNo = (TextView)  findViewById(R.id.lblMSlNo);
         VlblMSlNo = (TextView)  findViewById(R.id.VlblMSlNo);
         txtMSlNo = (EditText) findViewById(R.id.txtMSlNo);
         seclbl7=(LinearLayout) findViewById(R.id.seclbl7);
         linelbl7= (View) findViewById(R.id.linelbl7);
         secName = (LinearLayout) findViewById(R.id.secName);
         lineName = (View) findViewById(R.id.lineName);
         lblName = (TextView) findViewById(R.id.lblName);
         VlblName = (TextView)  findViewById(R.id.VlblName);
         txtName = (EditText) findViewById(R.id.txtName);
         secRth = (LinearLayout) findViewById(R.id.secRth);
         lineRth = (View) findViewById(R.id.lineRth);
         lblRth = (TextView) findViewById(R.id.lblRth);
         VlblRth = (TextView)   findViewById(R.id.VlblRth);
         spnRth = (Spinner) findViewById(R.id.spnRth);

         List<String> listRth = new ArrayList<String>();
         
         listRth.add("");
         listRth.add("01-খানা প্রধান");
         listRth.add("02-স্ত্রী অথবা স্বামী");
         listRth.add("03-ছেলে অথবা মেয়ে");
         listRth.add("04-মেয়ের জামাই অথবা ছেলের বউ");
         listRth.add("05- নাতি / নাতনী");
         listRth.add("06-বাবা / মা");
         listRth.add("07-শ্বশুর/শাশুড়ী");
         listRth.add("08- ভাই/বোন");
         listRth.add("09-অন্যান্য আত্মীয়—স্বজন");
         listRth.add("10-পালিত সন্তান/সৎ সন্তান");
         listRth.add("11-কোনো সম্পর্ক নেই");
         listRth.add("98- জানেন না");
         spnRth.setAdapter(new CustomSpinnerAdapter(this,new ArrayList<>(listRth)));

         spnRth.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnRth.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnRth.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("98"))
                 {
                    /*secRth_oth.setVisibility(View.GONE);
                    lineRth_oth.setVisibility(View.GONE);
                    txtRth_oth.setText("");*/
                     secRth_oth.setVisibility(View.VISIBLE);
                     lineRth_oth.setVisibility(View.VISIBLE);
                 }
                 else if(spnData.equalsIgnoreCase("09"))
                 {
                    /*secRth_oth.setVisibility(View.GONE);
                    lineRth_oth.setVisibility(View.GONE);
                    txtRth_oth.setText("");*/
                     secRth_oth.setVisibility(View.VISIBLE);
                     lineRth_oth.setVisibility(View.VISIBLE);
                 }
                 /*else
                 {
                    secRth_oth.setVisibility(View.VISIBLE);
                    lineRth_oth.setVisibility(View.VISIBLE);
                 }*/
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secRth_oth = findViewById(R.id.secRth_oth);
         lineRth_oth = findViewById(R.id.lineRth_oth);
         lblRth_oth = findViewById(R.id.lblRth_oth);
         VlblRth_oth = findViewById(R.id.VlblRth_oth);
         txtRth_oth = findViewById(R.id.txtRth_oth);
         txtRth_oth.setAdapter(C.getArrayAdapter("Select distinct Rth_oth from "+ TableName +" order by Rth_oth"));

         txtRth_oth.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View arg1, int pos,long id) {

             }
         });
         txtRth_oth.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT = 2;
         
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (txtRth_oth.getRight() - txtRth_oth.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         ((EditText)v).setText("");
                         return true;
                     }
                 }
                 return false;
             }
         });
         secSex = findViewById(R.id.secSex);
         lineSex = findViewById(R.id.lineSex);
         lblSex =  findViewById(R.id.lblSex);
         VlblSex =  findViewById(R.id.VlblSex);
         rdogrpSex =  findViewById(R.id.rdogrpSex);
         rdoSex1 =  findViewById(R.id.rdoSex1);
         rdoSex2 =  findViewById(R.id.rdoSex2);
         rdoSex3 =  findViewById(R.id.rdoSex3);
         secStayHH = findViewById(R.id.secStayHH);
         lineStayHH = findViewById(R.id.lineStayHH);
         lblStayHH =  findViewById(R.id.lblStayHH);
         VlblStayHH =  findViewById(R.id.VlblStayHH);
         rdogrpStayHH =  findViewById(R.id.rdogrpStayHH);
         rdoStayHH1 =  findViewById(R.id.rdoStayHH1);
         rdoStayHH2 =  findViewById(R.id.rdoStayHH2);
         secStayLastNight = findViewById(R.id.secStayLastNight);
         lineStayLastNight = findViewById(R.id.lineStayLastNight);
         lblStayLastNight =  findViewById(R.id.lblStayLastNight);
         VlblStayLastNight =  findViewById(R.id.VlblStayLastNight);
         rdogrpStayLastNight =  findViewById(R.id.rdogrpStayLastNight);
         rdoStayLastNight1 =  findViewById(R.id.rdoStayLastNight1);
         rdoStayLastNight2 =  findViewById(R.id.rdoStayLastNight2);
         secDOB = findViewById(R.id.secDOB);
         lineDOB = findViewById(R.id.lineDOB);
         lblDOB = findViewById(R.id.lblDOB);
         VlblDOB = findViewById(R.id.VlblDOB);
         txtDOB = findViewById(R.id.txtDOB);
         secDOBDk = findViewById(R.id.secDOBDk);
         lineDOBDk = findViewById(R.id.lineDOBDk);
         lblDOBDk = findViewById(R.id.lblDOBDk);
         VlblDOBDk = findViewById(R.id.VlblDOBDk);
         chkDOBDk = findViewById(R.id.chkDOBDk);
         secAgeY = findViewById(R.id.secAgeY);
         lineAgeY = findViewById(R.id.lineAgeY);
         lblAgeY = findViewById(R.id.lblAgeY);
         VlblAgeY = findViewById(R.id.VlblAgeY);
         txtAgeY = findViewById(R.id.txtAgeY);
         secMStatus = findViewById(R.id.secMStatus);
         lineMStatus = findViewById(R.id.lineMStatus);
         lblMStatus =  findViewById(R.id.lblMStatus);
         VlblMStatus =  findViewById(R.id.VlblMStatus);
         rdogrpMStatus =  findViewById(R.id.rdogrpMStatus);
         rdoMStatus1 =  findViewById(R.id.rdoMStatus1);
         rdoMStatus2 =  findViewById(R.id.rdoMStatus2);
         rdoMStatus3 =  findViewById(R.id.rdoMStatus3);
         rdoMStatus4 =  findViewById(R.id.rdoMStatus4);
         secAttendSchool = findViewById(R.id.secAttendSchool);
         lineAttendSchool = findViewById(R.id.lineAttendSchool);
         lblAttendSchool =  findViewById(R.id.lblAttendSchool);
         VlblAttendSchool =  findViewById(R.id.VlblAttendSchool);
         rdogrpAttendSchool =  findViewById(R.id.rdogrpAttendSchool);
         rdoAttendSchool1 =  findViewById(R.id.rdoAttendSchool1);
         rdoAttendSchool2 =  findViewById(R.id.rdoAttendSchool2);
         rdogrpAttendSchool.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpAttendSchool = new String[] {"1","2"};
             for (int i = 0; i < rdogrpAttendSchool.getChildCount(); i++)
             {
               rb = (RadioButton) rdogrpAttendSchool.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpAttendSchool[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secSchoolLevel.setVisibility(View.GONE);
                    lineSchoolLevel.setVisibility(View.GONE);
                    rdogrpSchoolLevel.clearCheck();
                    secHighestClass.setVisibility(View.GONE);
                    lineHighestClass.setVisibility(View.GONE);
                    txtHighestClass.setText("");
             }
             else
             {
                    secSchoolLevel.setVisibility(View.VISIBLE);
                    lineSchoolLevel.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secSchoolLevel = findViewById(R.id.secSchoolLevel);
         lineSchoolLevel = findViewById(R.id.lineSchoolLevel);
         lblSchoolLevel =  findViewById(R.id.lblSchoolLevel);
         VlblSchoolLevel =  findViewById(R.id.VlblSchoolLevel);
         rdogrpSchoolLevel =  findViewById(R.id.rdogrpSchoolLevel);
         rdoSchoolLevel1 =  findViewById(R.id.rdoSchoolLevel1);
         rdoSchoolLevel2 =  findViewById(R.id.rdoSchoolLevel2);
         rdoSchoolLevel3 =  findViewById(R.id.rdoSchoolLevel3);
         rdoSchoolLevel4 =  findViewById(R.id.rdoSchoolLevel4);
         rdoSchoolLevel5 =  findViewById(R.id.rdoSchoolLevel5);
         rdogrpSchoolLevel.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpSchoolLevel = new String[] {"1","2","3","6","8"};
             for (int i = 0; i < rdogrpSchoolLevel.getChildCount(); i++)
             {
               rb = (RadioButton) rdogrpSchoolLevel.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpSchoolLevel[i];
             }

             if(rbData.equalsIgnoreCase("8"))
             {
                    secHighestClass.setVisibility(View.GONE);
                    lineHighestClass.setVisibility(View.GONE);
                    txtHighestClass.setText("");
             }
             else
             {
                    secHighestClass.setVisibility(View.VISIBLE);
                    lineHighestClass.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secHighestClass = findViewById(R.id.secHighestClass);
         lineHighestClass = findViewById(R.id.lineHighestClass);
         lblHighestClass = findViewById(R.id.lblHighestClass);
         VlblHighestClass = findViewById(R.id.VlblHighestClass);
         txtHighestClass = findViewById(R.id.txtHighestClass);
         secWorkStatus = findViewById(R.id.secWorkStatus);
         lineWorkStatus = findViewById(R.id.lineWorkStatus);
         lblWorkStatus =  findViewById(R.id.lblWorkStatus);
         VlblWorkStatus =  findViewById(R.id.VlblWorkStatus);
         rdogrpWorkStatus =  findViewById(R.id.rdogrpWorkStatus);
         rdoWorkStatus1 =  findViewById(R.id.rdoWorkStatus1);
         rdoWorkStatus2 =  findViewById(R.id.rdoWorkStatus2);
         secHaveBRID = findViewById(R.id.secHaveBRID);
         lineHaveBRID = findViewById(R.id.lineHaveBRID);
         lblHaveBRID =  findViewById(R.id.lblHaveBRID);
         VlblHaveBRID =  findViewById(R.id.VlblHaveBRID);
         rdogrpHaveBRID =  findViewById(R.id.rdogrpHaveBRID);
         rdoHaveBRID1 =  findViewById(R.id.rdoHaveBRID1);
         rdoHaveBRID2 =  findViewById(R.id.rdoHaveBRID2);
         rdoHaveBRID3 =  findViewById(R.id.rdoHaveBRID3);
         rdoHaveBRID4 =  findViewById(R.id.rdoHaveBRID4);
         secHaveNID = findViewById(R.id.secHaveNID);
         lineHaveNID = findViewById(R.id.lineHaveNID);
         lblHaveNID =  findViewById(R.id.lblHaveNID);
         VlblHaveNID =  findViewById(R.id.VlblHaveNID);
         rdogrpHaveNID =  findViewById(R.id.rdogrpHaveNID);
         rdoHaveNID1 =  findViewById(R.id.rdoHaveNID1);
         rdoHaveNID2 =  findViewById(R.id.rdoHaveNID2);
         rdoHaveNID3 =  findViewById(R.id.rdoHaveNID3);
         secHaveMobile = findViewById(R.id.secHaveMobile);
         lineHaveMobile = findViewById(R.id.lineHaveMobile);
         lblHaveMobile =  findViewById(R.id.lblHaveMobile);
         VlblHaveMobile =  findViewById(R.id.VlblHaveMobile);
         rdogrpHaveMobile =  findViewById(R.id.rdogrpHaveMobile);
         rdoHaveMobile1 =  findViewById(R.id.rdoHaveMobile1);
         rdoHaveMobile2 =  findViewById(R.id.rdoHaveMobile2);
         secMoNo = findViewById(R.id.secMoNo);
         lineMoNo = findViewById(R.id.lineMoNo);
         lblMoNo = findViewById(R.id.lblMoNo);
         VlblMoNo = findViewById(R.id.VlblMoNo);
         spnMoNo = findViewById(R.id.spnMoNo);
         List<String> listMoNo = new ArrayList<String>();
         
         listMoNo.add("");
         listMoNo.add("1-হ্যাঁ");
         listMoNo.add("2-না");
         listMoNo.add("7-জানিনা");
         spnMoNo.setAdapter(new CustomSpinnerAdapter(this,new ArrayList<>(listMoNo)));

         secFaNo = findViewById(R.id.secFaNo);
         lineFaNo = findViewById(R.id.lineFaNo);
         lblFaNo = findViewById(R.id.lblFaNo);
         VlblFaNo = findViewById(R.id.VlblFaNo);
         spnFaNo = findViewById(R.id.spnFaNo);
         List<String> listFaNo = new ArrayList<String>();
         
         listFaNo.add("");
         listFaNo.add("1-হ্যাঁ");
         listFaNo.add("2-না");
         listFaNo.add("8-জানিনা");
         spnFaNo.setAdapter(new CustomSpinnerAdapter(this,new ArrayList<>(listFaNo)));

         secCurPreg = findViewById(R.id.secCurPreg);
         lineCurPreg = findViewById(R.id.lineCurPreg);
         lblCurPreg =  findViewById(R.id.lblCurPreg);
         VlblCurPreg =  findViewById(R.id.VlblCurPreg);
         rdogrpCurPreg =  findViewById(R.id.rdogrpCurPreg);
         rdoCurPreg1 =  findViewById(R.id.rdoCurPreg1);
         rdoCurPreg2 =  findViewById(R.id.rdoCurPreg2);
         rdoCurPreg3 =  findViewById(R.id.rdoCurPreg3);
     }
     catch(Exception  e)
     {
         Connection.MessageBox(HHMember.this, e.getMessage());
         return;
     }
 }

 private void DataSave()
 {
   try
     {
         String ValidationMSG = ValidationCheck();
         if(ValidationMSG.length()>0)
         {
         	Connection.MessageBox(HHMember.this, ValidationMSG);
         	return;
         }
 
         String SQL = "";
         RadioButton rb;

         HHMember_DataModel objSave = new HHMember_DataModel();
         objSave.setMEMID(txtMEMID.getText().toString());
         objSave.setVillID(txtVillID.getText().toString());
         objSave.setHHID(txtHHID.getText().toString());
         objSave.setMSlNo(txtMSlNo.getText().toString());
         objSave.setName(txtName.getText().toString());
         objSave.setRth(spnRth.getSelectedItemPosition() == 0 ? "" : spnRth.getSelectedItem().toString().split("-")[0]);
         objSave.setRth_oth(txtRth_oth.getText().toString());
         String[] d_rdogrpSex = new String[] {"1","2","3"};
         objSave.setSex("");
         for (int i = 0; i < rdogrpSex.getChildCount(); i++)
         {
             rb = (RadioButton) rdogrpSex.getChildAt(i);
             if (rb.isChecked()) objSave.setSex(d_rdogrpSex[i]);
         }

         String[] d_rdogrpStayHH = new String[] {"1","2"};
         objSave.setStayHH("");
         for (int i = 0; i < rdogrpStayHH.getChildCount(); i++)
         {
             rb = (RadioButton) rdogrpStayHH.getChildAt(i);
             if (rb.isChecked()) objSave.setStayHH(d_rdogrpStayHH[i]);
         }

         String[] d_rdogrpStayLastNight = new String[] {"1","2"};
         objSave.setStayLastNight("");
         for (int i = 0; i < rdogrpStayLastNight.getChildCount(); i++)
         {
             rb = (RadioButton) rdogrpStayLastNight.getChildAt(i);
             if (rb.isChecked()) objSave.setStayLastNight(d_rdogrpStayLastNight[i]);
         }

         objSave.setDOB(txtDOB.getText().toString().length() > 0 ? Global.DateConvertYMD(txtDOB.getText().toString()) : txtDOB.getText().toString());
         objSave.setDOBDk((chkDOBDk.isChecked() ? "1" : (secDOBDk.isShown() ? "2" : "")));
         objSave.setAgeY(txtAgeY.getText().toString());
         String[] d_rdogrpMStatus = new String[] {"1","2","3","4"};
         objSave.setMStatus("");
         for (int i = 0; i < rdogrpMStatus.getChildCount(); i++)
         {
             rb = (RadioButton) rdogrpMStatus.getChildAt(i);
             if (rb.isChecked()) objSave.setMStatus(d_rdogrpMStatus[i]);
         }

         String[] d_rdogrpAttendSchool = new String[] {"1","2"};
         objSave.setAttendSchool("");
         for (int i = 0; i < rdogrpAttendSchool.getChildCount(); i++)
         {
             rb = (RadioButton) rdogrpAttendSchool.getChildAt(i);
             if (rb.isChecked()) objSave.setAttendSchool(d_rdogrpAttendSchool[i]);
         }

         String[] d_rdogrpSchoolLevel = new String[] {"1","2","3","6","8"};
         objSave.setSchoolLevel("");
         for (int i = 0; i < rdogrpSchoolLevel.getChildCount(); i++)
         {
             rb = (RadioButton) rdogrpSchoolLevel.getChildAt(i);
             if (rb.isChecked()) objSave.setSchoolLevel(d_rdogrpSchoolLevel[i]);
         }

         objSave.setHighestClass(txtHighestClass.getText().toString());
         String[] d_rdogrpWorkStatus = new String[] {"1","2"};
         objSave.setWorkStatus("");
         for (int i = 0; i < rdogrpWorkStatus.getChildCount(); i++)
         {
             rb = (RadioButton) rdogrpWorkStatus.getChildAt(i);
             if (rb.isChecked()) objSave.setWorkStatus(d_rdogrpWorkStatus[i]);
         }

         String[] d_rdogrpHaveBRID = new String[] {"1","2","3","8"};
         objSave.setHaveBRID("");
         for (int i = 0; i < rdogrpHaveBRID.getChildCount(); i++)
         {
             rb = (RadioButton) rdogrpHaveBRID.getChildAt(i);
             if (rb.isChecked()) objSave.setHaveBRID(d_rdogrpHaveBRID[i]);
         }

         String[] d_rdogrpHaveNID = new String[] {"1","2","8"};
         objSave.setHaveNID("");
         for (int i = 0; i < rdogrpHaveNID.getChildCount(); i++)
         {
             rb = (RadioButton) rdogrpHaveNID.getChildAt(i);
             if (rb.isChecked()) objSave.setHaveNID(d_rdogrpHaveNID[i]);
         }

         String[] d_rdogrpHaveMobile = new String[] {"1","2"};
         objSave.setHaveMobile("");
         for (int i = 0; i < rdogrpHaveMobile.getChildCount(); i++)
         {
             rb = (RadioButton) rdogrpHaveMobile.getChildAt(i);
             if (rb.isChecked()) objSave.setHaveMobile(d_rdogrpHaveMobile[i]);
         }

         objSave.setMoNo(spnMoNo.getSelectedItemPosition() == 0 ? "" : spnMoNo.getSelectedItem().toString().split("-")[0]);
         objSave.setFaNo(spnFaNo.getSelectedItemPosition() == 0 ? "" : spnFaNo.getSelectedItem().toString().split("-")[0]);
         String[] d_rdogrpCurPreg = new String[] {"1","2","8"};
         objSave.setCurPreg("");
         for (int i = 0; i < rdogrpCurPreg.getChildCount(); i++)
         {
             rb = (RadioButton) rdogrpCurPreg.getChildAt(i);
             if (rb.isChecked()) objSave.setCurPreg(d_rdogrpCurPreg[i]);
         }

         objSave.setStartTime(STARTTIME);
         objSave.setEndTime(g.CurrentTime24());
         objSave.setDeviceID(DEVICEID);
         objSave.setEntryUser(ENTRYUSER); //from data entry user list
         objSave.setLat(MySharedPreferences.getValue(this, "lat"));
         objSave.setLon(MySharedPreferences.getValue(this, "lon"));

         String status = objSave.SaveUpdateData(this);
         if(status.length()==0) {
             Intent returnIntent = new Intent();
             returnIntent.putExtra("res", "");
             setResult(Activity.RESULT_OK, returnIntent);

            // Toast.makeText(HHMember.this,"Save Successfully...",Toast.LENGTH_SHORT).show();
             Connection.MessageBox(HHMember.this, "Save Successfully");
             finish();
         }
         else{
             Connection.MessageBox(HHMember.this, status);
             return;
         }
     }
     catch(Exception  e)
     {
         Connection.MessageBox(HHMember.this, e.getMessage());
         return;
     }
 }

 private String ValidationCheck()
 {
   String ValidationMsg = "";
   String DV = "";
   try
     {
         ResetSectionColor();
         if(txtMEMID.getText().toString().length()==0 & secMEMID.isShown())
           {
             ValidationMsg += "\n"+ lblMEMID.getText().toString() + " Required field: "+ VlblMEMID.getText().toString();
             secMEMID.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color_Section_Highlight));
           }
         if(txtVillID.getText().toString().length()==0 & secVillID.isShown())
           {
             ValidationMsg += "\n"+ lblVillID.getText().toString() + " Required field: "+ VlblVillID.getText().toString();
             secVillID.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color_Section_Highlight));
           }
         if(txtHHID.getText().toString().length()==0 & secHHID.isShown())
           {
             ValidationMsg += "\n"+ lblHHID.getText().toString() + " Required field: "+ VlblHHID.getText().toString();
             secHHID.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color_Section_Highlight));
           }
         if(txtMSlNo.getText().toString().length()==0 & secMSlNo.isShown())
           {
             ValidationMsg += "\n"+ lblMSlNo.getText().toString() + " Required field: "+ VlblMSlNo.getText().toString();
             secMSlNo.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color_Section_Highlight));
           }
         if(secMSlNo.isShown() & (Integer.parseInt(txtMSlNo.getText().toString().length()==0 ? "1" : txtMSlNo.getText().toString()) < 1 || Integer.parseInt(txtMSlNo.getText().toString().length()==0 ? "30" : txtMSlNo.getText().toString()) > 30))
           {
             ValidationMsg += "\n"+ lblMSlNo.getText().toString() + " Value should be between 1 and 30 (" + VlblMSlNo.getText().toString() +")";
             secMSlNo.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color_Section_Highlight));
           }
         if(txtName.getText().toString().length()==0 & secName.isShown())
           {
             ValidationMsg += "\n"+ lblName.getText().toString() + " Required field: "+ VlblName.getText().toString();
             secName.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color_Section_Highlight));
           }
         if(spnRth.getSelectedItemPosition()==0  & secRth.isShown())
           {
             ValidationMsg += "\n"+ lblRth.getText().toString() + " Required field: "+ VlblRth.getText().toString();
             secRth.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color_Section_Highlight));
           }
         if(txtRth_oth.getText().toString().length()==0 & secRth_oth.isShown())
           {
             ValidationMsg += "\n"+ lblRth_oth.getText().toString() + " Required field: "+ VlblRth_oth.getText().toString();
             secRth_oth.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color_Section_Highlight));
           }
         if(!rdoSex1.isChecked() & !rdoSex2.isChecked() & !rdoSex3.isChecked() & secSex.isShown())
           {
             ValidationMsg += "\n"+ lblSex.getText().toString() + " Required field: "+ VlblSex.getText().toString();
             secSex.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color_Section_Highlight));
           }
         if(!rdoStayHH1.isChecked() & !rdoStayHH2.isChecked() & secStayHH.isShown())
           {
             ValidationMsg += "\n"+ lblStayHH.getText().toString() + " Required field: "+ VlblStayHH.getText().toString();
             secStayHH.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color_Section_Highlight));
           }
         if(!rdoStayLastNight1.isChecked() & !rdoStayLastNight2.isChecked() & secStayLastNight.isShown())
           {
             ValidationMsg += "\n"+ lblStayLastNight.getText().toString() + " Required field: "+ VlblStayLastNight.getText().toString();
             secStayLastNight.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color_Section_Highlight));
           }
         DV = Global.DateValidate(txtDOB.getText().toString());
         if(DV.length()!=0 & secDOB.isShown())
           {
             ValidationMsg += "\n"+ lblDOB.getText().toString() + " Required field/Not a valid date format: "+ VlblDOB.getText().toString();
             secDOB.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color_Section_Highlight));
           }
         if(txtAgeY.getText().toString().length()==0 & secAgeY.isShown())
           {
             ValidationMsg += "\n"+ lblAgeY.getText().toString() + " Required field: "+ VlblAgeY.getText().toString();
             secAgeY.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color_Section_Highlight));
           }
         if(secAgeY.isShown() & (Integer.parseInt(txtAgeY.getText().toString().length()==0 ? "0" : txtAgeY.getText().toString()) < 0 || Integer.parseInt(txtAgeY.getText().toString().length()==0 ? "95" : txtAgeY.getText().toString()) > 95))
           {
             ValidationMsg += "\n"+ lblAgeY.getText().toString() + " Value should be between 0 and 95 (" + VlblAgeY.getText().toString() +")";
             secAgeY.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color_Section_Highlight));
           }
         if(!rdoMStatus1.isChecked() & !rdoMStatus2.isChecked() & !rdoMStatus3.isChecked() & !rdoMStatus4.isChecked() & secMStatus.isShown())
           {
             ValidationMsg += "\n"+ lblMStatus.getText().toString() + " Required field: "+ VlblMStatus.getText().toString();
             secMStatus.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color_Section_Highlight));
           }
         if(!rdoAttendSchool1.isChecked() & !rdoAttendSchool2.isChecked() & secAttendSchool.isShown())
           {
             ValidationMsg += "\n"+ lblAttendSchool.getText().toString() + " Required field: "+ VlblAttendSchool.getText().toString();
             secAttendSchool.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color_Section_Highlight));
           }
         if(!rdoSchoolLevel1.isChecked() & !rdoSchoolLevel2.isChecked() & !rdoSchoolLevel3.isChecked() & !rdoSchoolLevel4.isChecked() & !rdoSchoolLevel5.isChecked() & secSchoolLevel.isShown())
           {
             ValidationMsg += "\n"+ lblSchoolLevel.getText().toString() + " Required field: "+ VlblSchoolLevel.getText().toString();
             secSchoolLevel.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color_Section_Highlight));
           }
         if(txtHighestClass.getText().toString().length()==0 & secHighestClass.isShown())
           {
             ValidationMsg += "\n"+ lblHighestClass.getText().toString() + " Required field: "+ VlblHighestClass.getText().toString();
             secHighestClass.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color_Section_Highlight));
           }
         if(secHighestClass.isShown() & (Integer.parseInt(txtHighestClass.getText().toString().length()==0 ? "00" : txtHighestClass.getText().toString()) < 00 || Integer.parseInt(txtHighestClass.getText().toString().length()==0 ? "20" : txtHighestClass.getText().toString()) > 20))
           {
             ValidationMsg += "\n"+ lblHighestClass.getText().toString() + " Value should be between 00 and 20 (" + VlblHighestClass.getText().toString() +")";
             secHighestClass.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color_Section_Highlight));
           }
         if(!rdoWorkStatus1.isChecked() & !rdoWorkStatus2.isChecked() & secWorkStatus.isShown())
           {
             ValidationMsg += "\n"+ lblWorkStatus.getText().toString() + " Required field: "+ VlblWorkStatus.getText().toString();
             secWorkStatus.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color_Section_Highlight));
           }
         if(!rdoHaveBRID1.isChecked() & !rdoHaveBRID2.isChecked() & !rdoHaveBRID3.isChecked() & !rdoHaveBRID4.isChecked() & secHaveBRID.isShown())
           {
             ValidationMsg += "\n"+ lblHaveBRID.getText().toString() + " Required field: "+ VlblHaveBRID.getText().toString();
             secHaveBRID.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color_Section_Highlight));
           }
         if(!rdoHaveNID1.isChecked() & !rdoHaveNID2.isChecked() & !rdoHaveNID3.isChecked() & secHaveNID.isShown())
           {
             ValidationMsg += "\n"+ lblHaveNID.getText().toString() + " Required field: "+ VlblHaveNID.getText().toString();
             secHaveNID.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color_Section_Highlight));
           }
         if(!rdoHaveMobile1.isChecked() & !rdoHaveMobile2.isChecked() & secHaveMobile.isShown())
           {
             ValidationMsg += "\n"+ lblHaveMobile.getText().toString() + " Required field: "+ VlblHaveMobile.getText().toString();
             secHaveMobile.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color_Section_Highlight));
           }
         if(spnMoNo.getSelectedItemPosition()==0  & secMoNo.isShown())
           {
             ValidationMsg += "\n"+ lblMoNo.getText().toString() + " Required field: "+ VlblMoNo.getText().toString();
             secMoNo.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color_Section_Highlight));
           }
         if(spnFaNo.getSelectedItemPosition()==0  & secFaNo.isShown())
           {
             ValidationMsg += "\n"+ lblFaNo.getText().toString() + " Required field: "+ VlblFaNo.getText().toString();
             secFaNo.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color_Section_Highlight));
           }
         if(!rdoCurPreg1.isChecked() & !rdoCurPreg2.isChecked() & !rdoCurPreg3.isChecked() & secCurPreg.isShown())
           {
             ValidationMsg += "\n"+ lblCurPreg.getText().toString() + " Required field: "+ VlblCurPreg.getText().toString();
             secCurPreg.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color_Section_Highlight));
           }
     }
     catch(Exception  e)
     {
         ValidationMsg += "\n"+ e.getMessage();
     }

     return ValidationMsg;
 }

 private void ResetSectionColor()
 {
   try
     {
             secMEMID.setBackgroundColor(Color.WHITE);
             secVillID.setBackgroundColor(Color.WHITE);
             secHHID.setBackgroundColor(Color.WHITE);
             secMSlNo.setBackgroundColor(Color.WHITE);
             secMSlNo.setBackgroundColor(Color.WHITE);
             secName.setBackgroundColor(Color.WHITE);
             secRth.setBackgroundColor(Color.WHITE);
             secRth_oth.setBackgroundColor(Color.WHITE);
             secSex.setBackgroundColor(Color.WHITE);
             secStayHH.setBackgroundColor(Color.WHITE);
             secStayLastNight.setBackgroundColor(Color.WHITE);
             secDOB.setBackgroundColor(Color.WHITE);
             secAgeY.setBackgroundColor(Color.WHITE);
             secAgeY.setBackgroundColor(Color.WHITE);
             secMStatus.setBackgroundColor(Color.WHITE);
             secAttendSchool.setBackgroundColor(Color.WHITE);
             secSchoolLevel.setBackgroundColor(Color.WHITE);
             secHighestClass.setBackgroundColor(Color.WHITE);
             secHighestClass.setBackgroundColor(Color.WHITE);
             secWorkStatus.setBackgroundColor(Color.WHITE);
             secHaveBRID.setBackgroundColor(Color.WHITE);
             secHaveNID.setBackgroundColor(Color.WHITE);
             secHaveMobile.setBackgroundColor(Color.WHITE);
             secMoNo.setBackgroundColor(Color.WHITE);
             secFaNo.setBackgroundColor(Color.WHITE);
             secCurPreg.setBackgroundColor(Color.WHITE);
     }
     catch(Exception  e)
     {
     }
 }

 private void DataSearch(String MEMID)
     {
       try
        {     
           RadioButton rb;
           HHMember_DataModel d = new HHMember_DataModel();
           String SQL = "Select * from "+ TableName +"  Where MEMID='"+ MEMID +"'";
           List<HHMember_DataModel> data = d.SelectAll(this, SQL);
           for(HHMember_DataModel item : data){
             txtMEMID.setText(item.getMEMID());
             txtVillID.setText(item.getVillID());
             txtHHID.setText(item.getHHID());
             txtMSlNo.setText(String.valueOf(item.getMSlNo()));
             txtName.setText(item.getName());
             spnRth.setSelection(Global.SpinnerItemPositionAnyLength(spnRth, String.valueOf(item.getRth())));
             txtRth_oth.setText(item.getRth_oth());
             String[] d_rdogrpSex = new String[] {"1","2","3"};
             for (int i = 0; i < d_rdogrpSex.length; i++)
             {
                 if (String.valueOf(item.getSex()).equals(String.valueOf(d_rdogrpSex[i])))
                 {
                     rb = (RadioButton) rdogrpSex.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpStayHH = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpStayHH.length; i++)
             {
                 if (String.valueOf(item.getStayHH()).equals(String.valueOf(d_rdogrpStayHH[i])))
                 {
                     rb = (RadioButton) rdogrpStayHH.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpStayLastNight = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpStayLastNight.length; i++)
             {
                 if (String.valueOf(item.getStayLastNight()).equals(String.valueOf(d_rdogrpStayLastNight[i])))
                 {
                     rb = (RadioButton) rdogrpStayLastNight.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtDOB.setText(item.getDOB().toString().length()==0 ? "" : Global.DateConvertDMY(item.getDOB()));
             if(String.valueOf(item.getDOBDk()).equals("1"))
             {
                chkDOBDk.setChecked(true);
             }
             else if(String.valueOf(item.getDOBDk()).equals("2"))
             {
                chkDOBDk.setChecked(false);
             }
             txtAgeY.setText(String.valueOf(item.getAgeY()));
             String[] d_rdogrpMStatus = new String[] {"1","2","3","4"};
             for (int i = 0; i < d_rdogrpMStatus.length; i++)
             {
                 if (String.valueOf(item.getMStatus()).equals(String.valueOf(d_rdogrpMStatus[i])))
                 {
                     rb = (RadioButton) rdogrpMStatus.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpAttendSchool = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpAttendSchool.length; i++)
             {
                 if (String.valueOf(item.getAttendSchool()).equals(String.valueOf(d_rdogrpAttendSchool[i])))
                 {
                     rb = (RadioButton) rdogrpAttendSchool.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpSchoolLevel = new String[] {"1","2","3","6","8"};
             for (int i = 0; i < d_rdogrpSchoolLevel.length; i++)
             {
                 if (String.valueOf(item.getSchoolLevel()).equals(String.valueOf(d_rdogrpSchoolLevel[i])))
                 {
                     rb = (RadioButton) rdogrpSchoolLevel.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtHighestClass.setText(String.valueOf(item.getHighestClass()));
             String[] d_rdogrpWorkStatus = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpWorkStatus.length; i++)
             {
                 if (String.valueOf(item.getWorkStatus()).equals(String.valueOf(d_rdogrpWorkStatus[i])))
                 {
                     rb = (RadioButton) rdogrpWorkStatus.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpHaveBRID = new String[] {"1","2","3","8"};
             for (int i = 0; i < d_rdogrpHaveBRID.length; i++)
             {
                 if (String.valueOf(item.getHaveBRID()).equals(String.valueOf(d_rdogrpHaveBRID[i])))
                 {
                     rb = (RadioButton) rdogrpHaveBRID.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpHaveNID = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpHaveNID.length; i++)
             {
                 if (String.valueOf(item.getHaveNID()).equals(String.valueOf(d_rdogrpHaveNID[i])))
                 {
                     rb = (RadioButton) rdogrpHaveNID.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpHaveMobile = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpHaveMobile.length; i++)
             {
                 if (String.valueOf(item.getHaveMobile()).equals(String.valueOf(d_rdogrpHaveMobile[i])))
                 {
                     rb = (RadioButton) rdogrpHaveMobile.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             spnMoNo.setSelection(Global.SpinnerItemPositionAnyLength(spnMoNo, String.valueOf(item.getMoNo())));
             spnFaNo.setSelection(Global.SpinnerItemPositionAnyLength(spnFaNo, String.valueOf(item.getFaNo())));
             String[] d_rdogrpCurPreg = new String[] {"1","2","8"};
             for (int i = 0; i < d_rdogrpCurPreg.length; i++)
             {
                 if (String.valueOf(item.getCurPreg()).equals(String.valueOf(d_rdogrpCurPreg[i])))
                 {
                     rb = (RadioButton) rdogrpCurPreg.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
           }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(HHMember.this, e.getMessage());
            return;
        }
     }



 protected Dialog onCreateDialog(int id) {
   final Calendar c = Calendar.getInstance();
   hour = c.get(Calendar.HOUR_OF_DAY);
   minute = c.get(Calendar.MINUTE);
   switch (id) {
       case DATE_DIALOG:
           return new DatePickerDialog(this, mDateSetListener,g.mYear,g.mMonth-1,g.mDay);
       case TIME_DIALOG:
           return new TimePickerDialog(this, timePickerListener, hour, minute,false);
       }
     return null;
 }

 private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
      mYear = year; mMonth = monthOfYear+1; mDay = dayOfMonth;
      EditText dtpDate;


        dtpDate = findViewById(R.id.txtDOB);
      if (VariableID.equals("btnDOB"))
      {
          dtpDate = findViewById(R.id.txtDOB);
      }
        dtpDate.setText(new StringBuilder()
      .append(Global.Right("00"+mDay,2)).append("/")
      .append(Global.Right("00"+mMonth,2)).append("/")
      .append(mYear));
      }
  };

 private TimePickerDialog.OnTimeSetListener timePickerListener = new TimePickerDialog.OnTimeSetListener() {
    public void onTimeSet(TimePicker view, int selectedHour, int selectedMinute) {
       hour = selectedHour; minute = selectedMinute;
       EditText tpTime;

    }
  };


 
 // turning off the GPS if its in on state. to avoid the battery drain.
 @Override
 protected void onDestroy() {
     // TODO Auto-generated method stub
     super.onDestroy();
 }
}