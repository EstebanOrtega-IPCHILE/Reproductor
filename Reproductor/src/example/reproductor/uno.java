package example.reproductor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class uno extends Activity {
	
	private CheckBox cb1,cb2,cb3;
	private Button btnVerificar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.uno);
		
		
		cb1 = (CheckBox)findViewById(R.id.cb1);
		cb2 = (CheckBox)findViewById(R.id.cb2);
		cb3 = (CheckBox)findViewById(R.id.cb3);
		btnVerificar = (Button)findViewById(R.id.btnVerificar);
		
		
	}
	
	public void Verificar(View view){
		
		if(cb1.isChecked()==true){
			Toast toast = Toast.makeText(this, "Respuesta Correcta!!!", Toast.LENGTH_SHORT);
	        toast.show();
	        Intent i = new Intent(this, MainActivity.class);
			startActivity(i);
			
			
		}
		if(cb2.isChecked()==true){
			Toast toast = Toast.makeText(this, "Respuesta Incorrecta!!!", Toast.LENGTH_SHORT);
	        toast.show();
	        Intent i = new Intent(this, MainActivity.class);
			startActivity(i);
			
		}
		if(cb3.isChecked()==true){
			Toast toast = Toast.makeText(this, "Respuesta Incorrecta!!!", Toast.LENGTH_SHORT);
	        toast.show();
	        Intent i = new Intent(this, MainActivity.class);
			startActivity(i);
			
		}
		
	}

}
