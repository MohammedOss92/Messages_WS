package Classes;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by MUNZ 1985 on 29/3/2016.
 */
public class Messages implements Serializable, Parcelable

{

    private int MsgID;
    private String MsgDescription;
    private int TypeId;
    private int origPos;
    private int newMsg;
    private int isFav;
    private int orderFav;
  //  private String titleDescription ;

    public int getMsgID() {
        return MsgID;
    }

    public void setMsgID(int msgID) {
        MsgID = msgID;
    }

    public String getMsgDescription() {
        return MsgDescription;
    }

    public void setMsgDescription(String msgDescription) {
        MsgDescription = msgDescription;
    }

    public int getTypeId() {
        return TypeId;
    }

    public void setTypeId(int typeId) {
        TypeId = typeId;
    }

    public int getOrigPos() {
        return origPos;
    }

    public void setOrigPos(int origPos) {
        this.origPos = origPos;
    }

    public int getNewMsg() {
        return newMsg;
    }

    public void setNewMsg(int newMsg) {
        this.newMsg = newMsg;
    }

    public int getIsFav() {
        return isFav;
    }

    public void setIsFav(int isFav) {
        this.isFav = isFav;
    }

    public int getOrderFav() {
        return orderFav;
    }

    public void setOrderFav(int orderFav) {
        this.orderFav = orderFav;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }


}
