package com.example.viewpager2;

// ZoomOutPageTransformer.java

import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;

public class ZoomOutPageTransformer implements ViewPager2.PageTransformer {

    private static final float MIN_SCALE = 0.85f;
    private static final float MIN_ALPHA = 0.5f;

    @Override
    public void transformPage(@NonNull View page, float position) {
        int pageWidth = page.getWidth();
        int pageHeight = page.getHeight();

        if (position < -1) { // Página fuera de la pantalla a la izquierda
            page.setAlpha(0f);
        } else if (position <= 1) { // Página en la pantalla
            // Modificar la escala y la opacidad según la posición
            float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
            float verticalMargin = pageHeight * (1 - scaleFactor) / 2;
            float horizontalMargin = pageWidth * (1 - scaleFactor) / 2;
            if (position < 0) {
                page.setTranslationX(horizontalMargin - verticalMargin / 2);
            } else {
                page.setTranslationX(-horizontalMargin + verticalMargin / 2);
            }

            // Aplicar la escala y la opacidad
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
            page.setAlpha(MIN_ALPHA + (scaleFactor - MIN_SCALE) / (1 - MIN_SCALE) * (1 - MIN_ALPHA));
        } else { // Página fuera de la pantalla a la derecha
            page.setAlpha(0f);
        }
    }
}
