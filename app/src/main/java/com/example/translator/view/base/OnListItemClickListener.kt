package com.example.dictionary.view.base

import com.example.dictionary.presenter.DataPresenterRU

interface OnListItemClickListener {
    fun onItemClick(data: DataPresenterRU)
}