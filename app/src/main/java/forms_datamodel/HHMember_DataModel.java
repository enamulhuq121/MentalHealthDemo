package forms_datamodel;

import android.content.Context;
 import android.annotation.SuppressLint;
 import android.database.Cursor;
 import Common.Connection;
 import java.util.ArrayList;
 import java.util.List;
 import java.util.Map;
 import java.util.HashMap;
 import Utility.AuditTrial;
 import Common.Global;
 import android.content.ContentValues;

 public class HHMember_DataModel{

        private String _MEMID = "";
        public String getMEMID(){
              return _MEMID;
         }
        public void setMEMID(String newValue){
              _MEMID = newValue;
         }
        private String _VillID = "";
        public String getVillID(){
              return _VillID;
         }
        public void setVillID(String newValue){
              _VillID = newValue;
         }
        private String _HHID = "";
        public String getHHID(){
              return _HHID;
         }
        public void setHHID(String newValue){
              _HHID = newValue;
         }
        private String _MSlNo = "";
        public String getMSlNo(){
              return _MSlNo;
         }
        public void setMSlNo(String newValue){
              _MSlNo = newValue;
         }
        private String _Name = "";
        public String getName(){
              return _Name;
         }
        public void setName(String newValue){
              _Name = newValue;
         }
        private String _Rth = "";
        public String getRth(){
              return _Rth;
         }
        public void setRth(String newValue){
              _Rth = newValue;
         }
        private String _Rth_oth = "";
        public String getRth_oth(){
              return _Rth_oth;
         }
        public void setRth_oth(String newValue){
              _Rth_oth = newValue;
         }
        private String _Sex = "";
        public String getSex(){
              return _Sex;
         }
        public void setSex(String newValue){
              _Sex = newValue;
         }
        private String _StayHH = "";
        public String getStayHH(){
              return _StayHH;
         }
        public void setStayHH(String newValue){
              _StayHH = newValue;
         }
        private String _StayLastNight = "";
        public String getStayLastNight(){
              return _StayLastNight;
         }
        public void setStayLastNight(String newValue){
              _StayLastNight = newValue;
         }
        private String _DOB = "";
        public String getDOB(){
              return _DOB;
         }
        public void setDOB(String newValue){
              _DOB = newValue;
         }
        private String _DOBDk = "";
        public String getDOBDk(){
              return _DOBDk;
         }
        public void setDOBDk(String newValue){
              _DOBDk = newValue;
         }
        private String _AgeY = "";
        public String getAgeY(){
              return _AgeY;
         }
        public void setAgeY(String newValue){
              _AgeY = newValue;
         }
        private String _MStatus = "";
        public String getMStatus(){
              return _MStatus;
         }
        public void setMStatus(String newValue){
              _MStatus = newValue;
         }
        private String _AttendSchool = "";
        public String getAttendSchool(){
              return _AttendSchool;
         }
        public void setAttendSchool(String newValue){
              _AttendSchool = newValue;
         }
        private String _SchoolLevel = "";
        public String getSchoolLevel(){
              return _SchoolLevel;
         }
        public void setSchoolLevel(String newValue){
              _SchoolLevel = newValue;
         }
        private String _HighestClass = "";
        public String getHighestClass(){
              return _HighestClass;
         }
        public void setHighestClass(String newValue){
              _HighestClass = newValue;
         }
        private String _WorkStatus = "";
        public String getWorkStatus(){
              return _WorkStatus;
         }
        public void setWorkStatus(String newValue){
              _WorkStatus = newValue;
         }
        private String _HaveBRID = "";
        public String getHaveBRID(){
              return _HaveBRID;
         }
        public void setHaveBRID(String newValue){
              _HaveBRID = newValue;
         }
        private String _HaveNID = "";
        public String getHaveNID(){
              return _HaveNID;
         }
        public void setHaveNID(String newValue){
              _HaveNID = newValue;
         }
        private String _HaveMobile = "";
        public String getHaveMobile(){
              return _HaveMobile;
         }
        public void setHaveMobile(String newValue){
              _HaveMobile = newValue;
         }
        private String _MoNo = "";
        public String getMoNo(){
              return _MoNo;
         }
        public void setMoNo(String newValue){
              _MoNo = newValue;
         }
        private String _FaNo = "";
        public String getFaNo(){
              return _FaNo;
         }
        public void setFaNo(String newValue){
              _FaNo = newValue;
         }
        private String _CurPreg = "";
        public String getCurPreg(){
              return _CurPreg;
         }
        public void setCurPreg(String newValue){
              _CurPreg = newValue;
         }
        private String _StartTime = "";
        public void setStartTime(String newValue){
              _StartTime = newValue;
         }
        private String _EndTime = "";
        public void setEndTime(String newValue){
              _EndTime = newValue;
         }
        private String _DeviceID = "";
        public void setDeviceID(String newValue){
              _DeviceID = newValue;
         }
        private String _EntryUser = "";
        public void setEntryUser(String newValue){
              _EntryUser = newValue;
         }
        private String _Lat = "";
        public void setLat(String newValue){
              _Lat = newValue;
         }
        private String _Lon = "";
        public void setLon(String newValue){
              _Lon = newValue;
         }
        private String _EnDt = Global.DateTimeNowYMDHMS();
        private int _Upload = 2;
        private String _modifyDate = Global.DateTimeNowYMDHMS();

        String TableName = "HHMember";

        public String SaveUpdateData(Context context)
        {
            String response = "";
            C = new Connection(context);
            String SQL = "";
            try
            {
                 if(C.Existence("Select * from "+ TableName +"  Where MEMID='"+ _MEMID +"' "))
                    response = UpdateData(context);
                 else
                    response = SaveData(context);
            }
            catch(Exception  e)
            {
                 response = e.getMessage();
            }
           return response;
        }
        Connection C;

        private String SaveData(Context context)
        {
            String response = "";
            C = new Connection(context);
            try
              {
                 ContentValues contentValues = new ContentValues();
                 contentValues.put("MEMID", _MEMID);
                 contentValues.put("VillID", _VillID);
                 contentValues.put("HHID", _HHID);
                 contentValues.put("MSlNo", _MSlNo);
                 contentValues.put("Name", _Name);
                 contentValues.put("Rth", _Rth);
                 contentValues.put("Rth_oth", _Rth_oth);
                 contentValues.put("Sex", _Sex);
                 contentValues.put("StayHH", _StayHH);
                 contentValues.put("StayLastNight", _StayLastNight);
                 contentValues.put("DOB", _DOB);
                 contentValues.put("DOBDk", _DOBDk);
                 contentValues.put("AgeY", _AgeY);
                 contentValues.put("MStatus", _MStatus);
                 contentValues.put("AttendSchool", _AttendSchool);
                 contentValues.put("SchoolLevel", _SchoolLevel);
                 contentValues.put("HighestClass", _HighestClass);
                 contentValues.put("WorkStatus", _WorkStatus);
                 contentValues.put("HaveBRID", _HaveBRID);
                 contentValues.put("HaveNID", _HaveNID);
                 contentValues.put("HaveMobile", _HaveMobile);
                 contentValues.put("MoNo", _MoNo);
                 contentValues.put("FaNo", _FaNo);
                 contentValues.put("CurPreg", _CurPreg);
                 contentValues.put("isdelete", 2);
                 contentValues.put("StartTime", _StartTime);
                 contentValues.put("EndTime", _EndTime);
                 contentValues.put("DeviceID", _DeviceID);
                 contentValues.put("EntryUser", _EntryUser);
                 contentValues.put("Lat", _Lat);
                 contentValues.put("Lon", _Lon);
                 contentValues.put("EnDt", _EnDt);
                 contentValues.put("Upload", _Upload);
                 contentValues.put("modifyDate", _modifyDate);
                 C.InsertData(TableName, contentValues);
              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }

        private String UpdateData(Context context)
        {
            String response = "";
            C = new Connection(context);
            try
              {
                 ContentValues contentValues = new ContentValues();
                 contentValues.put("MEMID", _MEMID);
                 contentValues.put("VillID", _VillID);
                 contentValues.put("HHID", _HHID);
                 contentValues.put("MSlNo", _MSlNo);
                 contentValues.put("Name", _Name);
                 contentValues.put("Rth", _Rth);
                 contentValues.put("Rth_oth", _Rth_oth);
                 contentValues.put("Sex", _Sex);
                 contentValues.put("StayHH", _StayHH);
                 contentValues.put("StayLastNight", _StayLastNight);
                 contentValues.put("DOB", _DOB);
                 contentValues.put("DOBDk", _DOBDk);
                 contentValues.put("AgeY", _AgeY);
                 contentValues.put("MStatus", _MStatus);
                 contentValues.put("AttendSchool", _AttendSchool);
                 contentValues.put("SchoolLevel", _SchoolLevel);
                 contentValues.put("HighestClass", _HighestClass);
                 contentValues.put("WorkStatus", _WorkStatus);
                 contentValues.put("HaveBRID", _HaveBRID);
                 contentValues.put("HaveNID", _HaveNID);
                 contentValues.put("HaveMobile", _HaveMobile);
                 contentValues.put("MoNo", _MoNo);
                 contentValues.put("FaNo", _FaNo);
                 contentValues.put("CurPreg", _CurPreg);
                 contentValues.put("Upload", _Upload);
                 contentValues.put("modifyDate", _modifyDate);
                 C.UpdateData(TableName, "MEMID", (""+ _MEMID +""), contentValues);


              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }


        int Count = 0;
        private int _Count = 0;
        public int getCount(){ return _Count; }

        @SuppressLint("Range")
        public List<HHMember_DataModel> SelectAll(Context context, String SQL)
        {
            Connection C = new Connection(context);
            List<HHMember_DataModel> data = new ArrayList<HHMember_DataModel>();
            HHMember_DataModel d = new HHMember_DataModel();
            Cursor cur = C.ReadData(SQL);

            cur.moveToFirst();
            while(!cur.isAfterLast())
            {
                Count += 1;
                d = new HHMember_DataModel();
                d._Count = Count;
                d._MEMID = cur.getString(cur.getColumnIndex("MEMID"));
                d._VillID = cur.getString(cur.getColumnIndex("VillID"));
                d._HHID = cur.getString(cur.getColumnIndex("HHID"));
                d._MSlNo = cur.getString(cur.getColumnIndex("MSlNo"));
                d._Name = cur.getString(cur.getColumnIndex("Name"));
                d._Rth = cur.getString(cur.getColumnIndex("Rth"));
                d._Rth_oth = cur.getString(cur.getColumnIndex("Rth_oth"));
                d._Sex = cur.getString(cur.getColumnIndex("Sex"));
                d._StayHH = cur.getString(cur.getColumnIndex("StayHH"));
                d._StayLastNight = cur.getString(cur.getColumnIndex("StayLastNight"));
                d._DOB = cur.getString(cur.getColumnIndex("DOB"));
                d._DOBDk = cur.getString(cur.getColumnIndex("DOBDk"));
                d._AgeY = cur.getString(cur.getColumnIndex("AgeY"));
                d._MStatus = cur.getString(cur.getColumnIndex("MStatus"));
                d._AttendSchool = cur.getString(cur.getColumnIndex("AttendSchool"));
                d._SchoolLevel = cur.getString(cur.getColumnIndex("SchoolLevel"));
                d._HighestClass = cur.getString(cur.getColumnIndex("HighestClass"));
                d._WorkStatus = cur.getString(cur.getColumnIndex("WorkStatus"));
                d._HaveBRID = cur.getString(cur.getColumnIndex("HaveBRID"));
                d._HaveNID = cur.getString(cur.getColumnIndex("HaveNID"));
                d._HaveMobile = cur.getString(cur.getColumnIndex("HaveMobile"));
                d._MoNo = cur.getString(cur.getColumnIndex("MoNo"));
                d._FaNo = cur.getString(cur.getColumnIndex("FaNo"));
                d._CurPreg = cur.getString(cur.getColumnIndex("CurPreg"));
                data.add(d);



                cur.moveToNext();
            }
            cur.close();
          return data;
        }




 }