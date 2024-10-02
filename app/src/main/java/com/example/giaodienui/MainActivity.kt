package com.example.giaodienui

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var userAdapter: UserAdapter
    private val users = mutableListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageViewAvatar: ImageView = findViewById(R.id.imageViewAvatar)
        val editTextName: EditText = findViewById(R.id.editTextName)
        val editTextEmail: EditText = findViewById(R.id.editTextEmail)
        val editTextPhone: EditText = findViewById(R.id.editTextPhone)
        val radioGroupGender: RadioGroup = findViewById(R.id.radioGroupGender)
        val checkBoxAgreement: CheckBox = findViewById(R.id.checkBoxAgreement)
        val buttonSave: Button = findViewById(R.id.buttonSave)
        val recyclerViewUsers: RecyclerView = findViewById(R.id.recyclerViewUsers)

        userAdapter = UserAdapter(users)
        recyclerViewUsers.layoutManager = LinearLayoutManager(this)
        recyclerViewUsers.adapter = userAdapter

        // Enable button only when checkbox is checked
        checkBoxAgreement.setOnCheckedChangeListener { _, isChecked ->
            buttonSave.isEnabled = isChecked
        }

        // Save user information when button is clicked
        buttonSave.setOnClickListener {
            val name = editTextName.text.toString()
            val email = editTextEmail.text.toString()
            val phone = editTextPhone.text.toString()

            val selectedGenderId = radioGroupGender.checkedRadioButtonId
            val gender = when (selectedGenderId) {
                R.id.radioButtonMale -> "Nam"
                R.id.radioButtonFemale -> "Nữ"
                else -> "Khác"
            }

            // Add user info to the list
            val user = User(name, email, phone, gender)
            users.add(user)
            userAdapter.notifyDataSetChanged()

            // Clear input fields
            editTextName.text.clear()
            editTextEmail.text.clear()
            editTextPhone.text.clear()
            radioGroupGender.clearCheck()
            checkBoxAgreement.isChecked = false
        }
    }
}
