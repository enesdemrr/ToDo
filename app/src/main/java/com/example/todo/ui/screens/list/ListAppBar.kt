package com.example.todo.ui.screens.list

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.todo.R
import com.example.todo.components.PriorityItem
import com.example.todo.data.models.Priority
import com.example.todo.ui.theme.*

@Composable
fun ListAppBar() {
    DefaultListAppBar(
        onSearchClicked = {},
        onSortClicked = {},
        onDeleteClicked = {}
    )
}

@Composable
fun DefaultListAppBar(
    onSearchClicked: () -> Unit,
    onSortClicked: (Priority) -> Unit,
    onDeleteClicked: () -> Unit
) {
    TopAppBar(
        title = {
            Text(text = "Tasks", color = MaterialTheme.colors.topAppBarContentColor)
        },
        actions = {
            ListAppBarActions(
                onSearchClicked = onSearchClicked,
                onSortClicked = onSortClicked,
                onDeleteClicked = onDeleteClicked
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundContentColor
    )
}

@Composable
fun ListAppBarActions(
    onSearchClicked: () -> Unit,
    onSortClicked: (Priority) -> Unit,
    onDeleteClicked: () -> Unit
) {
    SearchAction(onSearchClicked = onSearchClicked)
    SortAction(onSortClicked = onSortClicked)
    DeleteAllAction(onDeleteClicked)
}

@Composable
fun SearchAction(
    onSearchClicked: () -> Unit
) {
    IconButton(
        onClick =
        { onSearchClicked() }
    ) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = stringResource(id = R.string.search_action),
            tint = MaterialTheme.colors.topAppBarContentColor
        )

    }
}

@Composable
fun SortAction(
    onSortClicked: (Priority) -> Unit
) {
    var expanded by remember {
        mutableStateOf(false)
    }
    IconButton(onClick = { expanded = true }) {
        Icon(
            painter = painterResource(id = R.drawable.ic_filter_list),
            contentDescription = stringResource(
                id = R.string.sort_action
            )
        )
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            DropdownMenuItem(onClick = { expanded = false }) {
                PriorityItem(priority = Priority.LOW)
                onSortClicked(Priority.LOW)
            }
            DropdownMenuItem(onClick = { expanded = false }) {
                PriorityItem(priority = Priority.HIGH)
                onSortClicked(Priority.HIGH)
            }
            DropdownMenuItem(onClick = { expanded = false }) {
                PriorityItem(priority = Priority.NONE)
                onSortClicked(Priority.NONE)
            }

        }

    }
}

@Composable
fun DeleteAllAction(onDeleteClicked: () -> Unit) {
    var expanded by remember {
        mutableStateOf(false)
    }
    IconButton(onClick = { expanded = true }) {
        Icon(
            painter = painterResource(id = R.drawable.ic_vertical_menu),
            contentDescription = stringResource(
                id = R.string.sort_action
            )
        )
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            DropdownMenuItem(
                onClick = {
                    expanded = false
                    onDeleteClicked
                }
            ) {
                Text(
                    modifier = Modifier.padding(LARGE_PADDING),
                    text = stringResource(id = R.string.delete_all_action),
                    style = Typography.subtitle2
                )
            }
        }
    }
}

@Composable
@Preview
private fun DefaultListAppBarPreview() {
    DefaultListAppBar(
        onSearchClicked = {},
        onSortClicked = {},
        onDeleteClicked = {}
    )
}