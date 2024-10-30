package com.example.gmailapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        setupWindowInsets()

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = EmailAdapter(getEmailList())
    }

    // Set up window insets for edge-to-edge display
    private fun setupWindowInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // Create a list of sample emails
    private fun getEmailList(): List<Email> {
        return listOf(
            Email("An", "Thông Báo Họp", "Cuộc họp quan trọng sẽ diễn ra vào lúc 3:00 chiều", "2:30 chiều"),
            Email("Bình", "Cập Nhật Tình Hình", "Có một số thay đổi trong kế hoạch dự án...", "Hôm qua"),
            Email("Cường", "Nhắc Nhở Cuộc Họp", "Xin nhắc bạn về cuộc họp sáng mai lúc 9:00 sáng", "8:00 sáng"),
            Email("Duyên", "Khuyến Mãi Đặc Biệt", "Giảm giá 30% cho đơn hàng đầu tiên của bạn!", "10:00 sáng"),
            Email("Hà", "Đề Xuất Ăn Trưa", "Có ai muốn đi ăn trưa không? Chúng ta có thể thử nhà hàng mới.", "11:15 sáng"),
            Email("Kiên", "Thông Báo Dự Án", "Dự án đã hoàn thành giai đoạn đầu và sắp đi vào hoạt động.", "11:50 sáng"),
            Email("Lan", "Mã Giảm Giá Đặc Biệt", "Dùng mã 'LAN20' để được giảm giá 20% khi mua hàng!", "12:30 chiều")
        )
    }
}
