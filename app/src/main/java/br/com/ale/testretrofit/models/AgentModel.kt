package br.com.ale.testretrofit.models

data class AgentModel(
    val abilities: List<AbilityModel>,
    val assetPath: String,
    val background: String,
    val backgroundGradientColors: List<String>,
    val bustPortrait: String,
    val characterTags: Any,
    val description: String,
    val developerName: String,
    val displayIcon: String,
    val displayIconSmall: String,
    val displayName: String,
    val fullPortrait: String,
    val fullPortraitV2: String,
    val isAvailableForTest: Boolean,
    val isBaseContent: Boolean,
    val isFullPortraitRightFacing: Boolean,
    val isPlayableCharacter: Boolean,
    val killfeedPortrait: String,
    val recruitmentData: Any,
    val role: RoleModel,
    val uuid: String,
    val voiceLine: Any
)