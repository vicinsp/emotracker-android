package com.conlage.emotracker.features.home.data.model

import com.conlage.emotracker.features.home.domain.entity.Activity
import com.conlage.emotracker.features.home.domain.entity.Situation

data class ActivitiesResponse(
   val activities: List<Activity>
)
