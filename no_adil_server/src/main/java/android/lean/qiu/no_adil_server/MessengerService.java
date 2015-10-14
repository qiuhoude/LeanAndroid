package android.lean.qiu.no_adil_server;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

public class MessengerService extends Service {
    private static final int MSG_SUM = 0x110;


    @Override
    public IBinder onBind(Intent intent) {
        return mMessenger.getBinder();
    }


    //��û���HandlerThread����ʽ
    private Messenger mMessenger = new Messenger(new Handler()
    {
        @Override
        public void handleMessage(Message msgfromClient)
        {
            Message msgToClient = Message.obtain(msgfromClient);//���ظ��ͻ��˵���Ϣ
            switch (msgfromClient.what)
            {
                //msg �ͻ��˴�������Ϣ
                case MSG_SUM:
                    msgToClient.what = MSG_SUM;
                    try
                    {
                        //ģ���ʱ
                        Thread.sleep(2000);
                        msgToClient.arg2 = msgfromClient.arg1 + msgfromClient.arg2;
                        msgfromClient.replyTo.send(msgToClient);
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    } catch (RemoteException e)
                    {
                        e.printStackTrace();
                    }
                    break;
            }

            super.handleMessage(msgfromClient);
        }
    });
}
