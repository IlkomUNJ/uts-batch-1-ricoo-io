package com.example.mid_term_project

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Modifier
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.material.icons.filled.Save
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.TextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun addEditContactScreen(navController: NavController, contactId: Int?) {
    val contact = contacts.find { it.id == contactId } ?: return
    var contactName by remember { mutableStateOf(TextFieldValue(contact.contactName)) }
    var contactNumber by remember { mutableStateOf(TextFieldValue(contact.contactNumber)) }
    var contactAddress by remember { mutableStateOf(TextFieldValue(contact.contactAddress)) }
    var contactEmail by remember { mutableStateOf(TextFieldValue(contact.contactEmail)) }
    var textStyle by remember { mutableStateOf(TextStyle(fontSize = 16.sp)) }
    var textSize by remember { mutableStateOf(16f) }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .imePadding(),
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                ),
                title = { Text(contact.contactName) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            modifier = Modifier.graphicsLayer(scaleX = -1f),
                            imageVector = Icons.Filled.ExitToApp,
                            contentDescription = "Back"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {
                        val index = contacts.indexOfFirst { it.id == contact.id }
                        if (index >= 0) {
                            contacts[index] = contact.copy(
                                contactName = contactName.text,
                                contactNumber = contactNumber.text,
                                contactAddress = contactAddress.text
                            )
                        }
                        navController.popBackStack()
                    }) {
                        Icon(Icons.Default.Save, contentDescription = "Save Contact")
                    }
                }
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Contact Name:",
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(8.dp))

                TextField(
                    value = contactName,
                    onValueChange = { contactName = it },
                    textStyle = textStyle,
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = {
                        Text(
                            "Enter phone number",
                            fontSize = textSize.sp,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                        )
                    }
                )

                Text(
                    text = "Add or Edit Contact Number:",
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(8.dp))

                TextField(
                    value = contactNumber,
                    onValueChange = { contactNumber = it },
                    textStyle = textStyle,
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = {
                        Text(
                            "Enter phone number",
                            fontSize = textSize.sp,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                        )
                    }
                )

                Text(
                    text = "Add or Edit Contact Address:",
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(8.dp))

                TextField(
                    value = contactAddress,
                    onValueChange = { contactAddress = it },
                    textStyle = textStyle,
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = {
                        Text(
                            "Enter contact address",
                            fontSize = textSize.sp,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                        )
                    }
                )

                Text(
                    text = "Add or Edit Contact Email:",
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(8.dp))

                TextField(
                    value = contactEmail,
                    onValueChange = { contactEmail = it },
                    textStyle = textStyle,
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = {
                        Text(
                            "Enter contact address",
                            fontSize = textSize.sp,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                        )
                    }
                )
            }
        }
    )
}