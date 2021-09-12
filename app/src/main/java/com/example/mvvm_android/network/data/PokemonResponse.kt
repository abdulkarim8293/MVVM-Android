package com.example.mvvm_android.network.data

data class PokemonResponse (
    val abilities:List<Abilities>,
    val base_experience:Int,
    val forms:List<Form>,
    val game_indices:List<GameIndices>,
    val height:Int,
    val held_items:List<HeldItems>,
    val id:Int,
    val is_default:Boolean,
    val location_area_encounters:String,
    val moves:List<Moves>,
    val name:String,
    val order:String,
    val species: Species,
    val sprites: Sprites,
    val stats:List<Stats>,
    val types:List<Types>,
    val weight:Int,
)

data class Abilities(
    val ability:Ability,
    val is_hidden:Boolean,
    val slot:Int
)
data class Ability(
    val name:String,
    val url:String,
)
data class Form(
    val name: String,
    val url: String
)
data class GameIndices(
    val game_index:Int,
    val version: Version
)
data class Version(
    val name: String,
    val url: String
)
data class HeldItems(
    val item: Item,
    val version_details:List<VersionDetail>
)
data class Item(
    val name: String,
    val url: String
)
data class VersionDetail(
    val rarity:Int,
    val version: Version
)
data class Moves(
    val move: Move,
    val version_group_details:List<VersionGroupDetails>
)
data class Move(
    val name: String,
    val url: String
)
data class VersionGroupDetails(
    val level_learned_at:Int,
    val move_learn_method:MoveLearnMethod,
    val version_group:VersionGroup,
)
data class MoveLearnMethod(
    val name: String,
    val url: String
)
data class VersionGroup(
    val name: String,
    val url: String
)
data class Species(
    val name: String,
    val url: String
)
data class Sprites(
    val back_default: String,
    val back_female: String,
    val back_shiny: String,
    val back_shiny_female: String,
    val front_default: String,
    val front_female: String,
    val front_shiny: String,
    val front_shiny_female: String
)
data class Stats(
    val base_stat:Int,
    val effort:Int,
    val stat: Stat
)
data class Stat(
    val name: String,
    val url: String
)
data class Types(
    val slot:Int,
    val type: Type
)
data class Type(
    val name: String,
    val url: String
)





