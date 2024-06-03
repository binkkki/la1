package com.ncfu.a123;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }

    class MyView extends View {

        public MyView(Context context) {
            super(context);
        }
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            Paint paint = new Paint();
            Path path = new Path();

            //красный круг
            paint.setColor(Color.RED);
            canvas.drawCircle(100, 200, 50, paint);

            //красный прямоугольник
            Rect redRect = new Rect(200, 250, 400, 200);
            canvas.drawRect(redRect, paint);

            //размеры экрана телефона
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            int screenWidth = displayMetrics.widthPixels;
            int screenHeight = displayMetrics.heightPixels;
            int screenSize = 2 * (screenWidth + screenHeight);
            int squarePerimeter = screenSize / 2;
            int squareSide = squarePerimeter / 4;
            //синий квадрат с периметром в 2 раза меньше периметра экрана
            paint.setColor(Color.BLUE);
            canvas.drawRect((screenWidth - squareSide) / 2, (screenHeight - squareSide) / 2, (screenWidth + squareSide) / 2, (screenHeight + squareSide) / 2, paint);

            //кот
            int color1 = Color.parseColor("#000000"); // Черный
            int color2 = Color.parseColor("#42AAFF"); // Синий
            int color3 = Color.parseColor("#808080"); // Серый

            //тело
            paint.setColor(color3);
            canvas.drawCircle(370, 490, 120, paint);


            //уши
            paint.setColor(color3);
            path.reset();
            path.moveTo(490, 350);
            path.lineTo(440, 400);
            path.lineTo(485, 450);
            path.close();
            canvas.drawPath(path, paint);

            path.reset();
            path.moveTo(250, 350);
            path.lineTo(300, 400);
            path.lineTo(255, 450);
            path.close();
            canvas.drawPath(path, paint);

            //глаза
            paint.setColor(color2);
            canvas.drawCircle(320, 470, 22, paint);
            canvas.drawCircle(420, 470, 22, paint);

            //нос
            path.reset();
            paint.setColor(color1);
            path.moveTo(345, 500);
            path.lineTo(395, 500);
            path.lineTo(370, 525);
            path.close();
            canvas.drawPath(path, paint);

            //рот
            paint.setColor(color1);
            path.reset();
            path.moveTo(410, 550);
            path.quadTo(370,585,330,550);
            canvas.drawPath(path, paint);

            paint.setStrokeWidth(5);
            //усы
            canvas.drawLine(240, 570, 290, 550, paint);
            canvas.drawLine(220, 540, 280, 540, paint);
            canvas.drawLine(230, 510, 280, 530, paint);
            canvas.drawLine(450, 550, 500, 570, paint);
            canvas.drawLine(460, 540, 520, 540, paint);
            canvas.drawLine(460, 530, 510, 510, paint);
        }
    }
}
