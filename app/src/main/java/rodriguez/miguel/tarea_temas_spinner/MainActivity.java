package rodriguez.miguel.tarea_temas_spinner;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.content.res.TypedArray;
import android.view.ViewGroup;
import android.widget.TextView;





public class MainActivity extends AppCompatActivity {

    private Spinner styleSpinner;
    private RelativeLayout mainLayout;
    private Button myButton;
    private TextView myTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        styleSpinner = findViewById(R.id.style_spinner);
        mainLayout = findViewById(R.id.main_layout);
        myButton = findViewById(R.id.button_login);
        myTextView = findViewById(R.id.text_contraseña);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.styles_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        styleSpinner.setAdapter(adapter);

        styleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position) {
                    case 0: // Estilo 1
                        applyStyleToLayout(mainLayout, R.style.Estilo1);
                        myButton.setBackgroundColor(getColor(R.color.style1_boton));
                        myButton.setTextColor(getColor(R.color.style1_text));
                        myTextView.setTextColor(getColor(R.color.style1_text));
                        break;
                    case 1: // Estilo 2
                        applyStyleToLayout(mainLayout, R.style.Estilo2);
                        myButton.setBackgroundColor(getColor(R.color.style2_boton));
                        myButton.setTextColor(getColor(R.color.style2_text));
                        myTextView.setTextColor(getColor(R.color.style2_text));
                        break;
                    case 2: // Estilo 3
                        applyStyleToLayout(mainLayout, R.style.Estilo3);
                        myButton.setBackgroundColor(getColor(R.color.style3_boton));
                        myButton.setTextColor(getColor(R.color.style3_text));
                        myTextView.setTextColor(getColor(R.color.style3_text));
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void applyStyleToLayout(View layout, int styleResId) {
        TypedArray a = getTheme().obtainStyledAttributes(styleResId, R.styleable.CustomTheme);
        int colorFondo = a.getColor(R.styleable.CustomTheme_colorFondo, 0);
        int colorTexto = a.getColor(R.styleable.CustomTheme_colorTexto, 0);
        a.recycle();

        layout.setBackgroundColor(colorFondo);

        for (int i = 0; i < ((ViewGroup) layout).getChildCount(); i++) {
            View child = ((ViewGroup) layout).getChildAt(i);
            if (child instanceof TextView) {
                ((TextView) child).setTextColor(colorTexto);
            }
        }
    }
}
