package dev.kevinp.composecanvas

import android.graphics.Paint
import android.graphics.Typeface
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.kevinp.composecanvas.ui.theme.ComposeCanvasDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCanvasDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    GetAllIcons()
                }
            }
        }
    }
}

@Composable
fun GetAllIcons() {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Row(horizontalArrangement = Arrangement.SpaceAround) {
            InstagramIcon()
            FacebookIcon()
            MessengerIcon()
        }
        Row(horizontalArrangement = Arrangement.SpaceAround) {
            GooglePhotoIcon()
            WeatherAppIcon()
        }
    }
}

@Composable
fun InstagramIcon(
    size: Dp = 100.dp,
    padding: Dp = 16.dp
) {
    // For gradient colors
    val instaColors = listOf(Color.Yellow, Color.Red, Color.Magenta)

    Canvas(
        modifier = Modifier
            .size(size)
            .padding(padding)
    ) {
        // outer round rect
        drawRoundRect(
            brush = Brush.linearGradient(colors = instaColors),
            cornerRadius = CornerRadius(60f, 60f),
            style = Stroke(width = 15f, cap = StrokeCap.Round)
        )
        // inner center circle
        drawCircle(
            brush = Brush.linearGradient(colors = instaColors),
            radius = 45f,
            style = Stroke(width = 15f, cap = StrokeCap.Round)

        )
        // small circle
        drawCircle(
            brush = Brush.linearGradient(colors = instaColors),
            radius = 13f,
            center = Offset(this.size.width * .8f, this.size.height * .2f)
        )
    }
}

@Composable
fun FacebookIcon(
    size: Dp = 100.dp,
    padding: Dp = 16.dp
) {
    val assetManager = LocalContext.current.assets
    // For typeface 'f'
    val paint = Paint().apply {
        textAlign = Paint.Align.CENTER
        textSize = 200f
        color = Color.White.toArgb()
        typeface = Typeface.createFromAsset(assetManager, "FACEBOLF.OTF")
    }

    Canvas(
        modifier = Modifier
            .size(size)
            .padding(padding)
    ) {
        drawRoundRect(
            color = Color(0xFF1776d1),
            cornerRadius = CornerRadius(20f, 20f)
        )
        drawContext.canvas.nativeCanvas.drawText("f", center.x + 25, center.y + 90, paint)
    }
}

@Composable
fun MessengerIcon(
    size: Dp = 100.dp,
    padding: Dp = 16.dp
) {
    val colors = listOf(Color(0xFF02b8f9), Color(0xFF0277fe))
    Canvas(
        modifier = Modifier
            .size(size)
            .padding(padding)
    ) {
        val trianglePath = Path().let {
            it.moveTo(this.size.width * .2f, this.size.height * .77f)
            it.lineTo(this.size.width * .2f, this.size.height * .95f)
            it.lineTo(this.size.width * .37f, this.size.height * .86f)
            it.close()
            it
        }

        val electricPath = Path().let {
            it.moveTo(this.size.width * .2f, this.size.height * .6f)
            it.lineTo(this.size.width * .45f, this.size.height * .35f)
            it.lineTo(this.size.width * .56f, this.size.height * .46f)
            it.lineTo(this.size.width * .78f, this.size.height * .35f)
            it.lineTo(this.size.width * .54f, this.size.height * .60f)
            it.lineTo(this.size.width * .43f, this.size.height * .45f)
            it.close()
            it
        }

        drawOval(
            Brush.verticalGradient(colors = colors),
            size = Size(this.size.width, this.size.height * .95f)
        )

        drawPath(
            path = trianglePath,
            Brush.verticalGradient(colors = colors),
            style = Stroke(width = 15f, cap = StrokeCap.Round)
        )

        drawPath(path = electricPath, color = Color.White)
    }
}

@Composable
fun GooglePhotoIcon(
    size: Dp = 100.dp,
    padding: Dp = 16.dp
) {
    Canvas(
        modifier = Modifier
            .size(size)
            .padding(padding)
    ) {
        drawArc(
            color = Color(0xFFf04231),
            startAngle = -90f,
            sweepAngle = 180f,
            useCenter = true,
            size = Size(this.size.width * .5f, this.size.height * .5f),
            topLeft = Offset(this.size.width * .25f, 0f)
        )
        drawArc(
            color = Color(0xFF4385f7),
            startAngle = 0f,
            sweepAngle = 180f,
            useCenter = true,
            size = Size(this.size.width * .5f, this.size.height * .5f),
            topLeft = Offset(this.size.width * .50f, this.size.height * .25f)
        )
        drawArc(
            color = Color(0xFF30a952),
            startAngle = 0f,
            sweepAngle = -180f,
            useCenter = true,
            size = Size(this.size.width * .5f, this.size.height * .5f),
            topLeft = Offset(0f, this.size.height * .25f)
        )
        drawArc(
            color = Color(0xFFffbf00),
            startAngle = 270f,
            sweepAngle = -180f,
            useCenter = true,
            size = Size(this.size.width * .5f, this.size.height * .5f),
            topLeft = Offset(this.size.width * .25f, this.size.height * .5f)
        )
    }
}

@Composable
fun WeatherAppIcon(
    size: Dp = 100.dp,
    padding: Dp = 16.dp
) {
    val backgroundColor = listOf(Color(0xFF2078ee), Color(0xFF74e6fe))
    val sunColor = listOf(Color(0xFFffc200), Color(0xFFffe100))
    Canvas(
        modifier = Modifier
            .size(size)
            .padding(padding)
    ) {
        val width = this.size.width
        val height = this.size.height
        val path = Path().apply {
            moveTo(width.times(.76f), height.times(.72f))
            cubicTo(
                width.times(.93f), height.times(.72f),
                width.times(.98f), height.times(.41f),
                width.times(.76f), height.times(.40f)
            )
            cubicTo(
                width.times(.75f), height.times(.21f),
                width.times(.35f), height.times(.21f),
                width.times(.38f), height.times(.50f)
            )
            cubicTo(
                width.times(.25f), height.times(.50f),
                width.times(.20f), height.times(.69f),
                width.times(.41f), height.times(.72f)
            )
            close()
        }

        drawRoundRect(
            Brush.verticalGradient(backgroundColor),
            cornerRadius = CornerRadius(50f, 50f)
        )
        drawCircle(
            Brush.verticalGradient(sunColor),
            radius = width.times(.17f),
            center = Offset(width.times(.35f), height.times(.35f))
        )
        drawPath(path = path, color = Color.White.copy(alpha = .9f))
    }
}

@Preview
@Composable
fun IconPreview() {
    ComposeCanvasDemoTheme {
        Column {
            InstagramIcon()
            FacebookIcon()
            MessengerIcon()
            GooglePhotoIcon()
            WeatherAppIcon()
        }
    }
}