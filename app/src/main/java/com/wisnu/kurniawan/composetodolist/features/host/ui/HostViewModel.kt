package com.wisnu.kurniawan.composetodolist.features.host.ui

import androidx.lifecycle.viewModelScope
import com.wisnu.kurniawan.composetodolist.features.host.data.IHostEnvironment
import com.wisnu.foundation.coreviewmodel.StatefulViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HostViewModel @Inject constructor(hostEnvironment: IHostEnvironment) :
    StatefulViewModel<HostState, Unit, Unit, IHostEnvironment>(HostState(), hostEnvironment) {

    init {
        initTheme()
    }

    override fun dispatch(action: Unit) {

    }

    private fun initTheme() {
        viewModelScope.launch {
            environment.getTheme()
                .collect { setState { copy(theme = it) } }
        }
    }

}


