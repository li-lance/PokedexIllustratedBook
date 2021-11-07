package com.pokedex.illustratedbook.api

import com.pokedex.illustratedbook.model.Ability
import com.pokedex.illustratedbook.model.ApiResourceList
import com.pokedex.illustratedbook.model.Berry
import com.pokedex.illustratedbook.model.BerryFirmness
import com.pokedex.illustratedbook.model.BerryFlavor
import com.pokedex.illustratedbook.model.Characteristic
import com.pokedex.illustratedbook.model.ContestEffect
import com.pokedex.illustratedbook.model.ContestType
import com.pokedex.illustratedbook.model.EggGroup
import com.pokedex.illustratedbook.model.EncounterCondition
import com.pokedex.illustratedbook.model.EncounterConditionValue
import com.pokedex.illustratedbook.model.EncounterMethod
import com.pokedex.illustratedbook.model.EvolutionChain
import com.pokedex.illustratedbook.model.EvolutionTrigger
import com.pokedex.illustratedbook.model.Gender
import com.pokedex.illustratedbook.model.Generation
import com.pokedex.illustratedbook.model.GrowthRate
import com.pokedex.illustratedbook.model.Item
import com.pokedex.illustratedbook.model.ItemAttribute
import com.pokedex.illustratedbook.model.ItemCategory
import com.pokedex.illustratedbook.model.ItemFlingEffect
import com.pokedex.illustratedbook.model.ItemPocket
import com.pokedex.illustratedbook.model.Language
import com.pokedex.illustratedbook.model.Location
import com.pokedex.illustratedbook.model.LocationArea
import com.pokedex.illustratedbook.model.LocationAreaEncounter
import com.pokedex.illustratedbook.model.Machine
import com.pokedex.illustratedbook.model.Move
import com.pokedex.illustratedbook.model.MoveAilment
import com.pokedex.illustratedbook.model.MoveBattleStyle
import com.pokedex.illustratedbook.model.MoveCategory
import com.pokedex.illustratedbook.model.MoveDamageClass
import com.pokedex.illustratedbook.model.MoveLearnMethod
import com.pokedex.illustratedbook.model.MoveTarget
import com.pokedex.illustratedbook.model.NamedApiResourceList
import com.pokedex.illustratedbook.model.Nature
import com.pokedex.illustratedbook.model.PalParkArea
import com.pokedex.illustratedbook.model.PokeathlonStat
import com.pokedex.illustratedbook.model.Pokedex
import com.pokedex.illustratedbook.model.Pokemon
import com.pokedex.illustratedbook.model.PokemonColor
import com.pokedex.illustratedbook.model.PokemonForm
import com.pokedex.illustratedbook.model.PokemonHabitat
import com.pokedex.illustratedbook.model.PokemonShape
import com.pokedex.illustratedbook.model.PokemonSpecies
import com.pokedex.illustratedbook.model.Region
import com.pokedex.illustratedbook.model.Stat
import com.pokedex.illustratedbook.model.SuperContestEffect
import com.pokedex.illustratedbook.model.Type
import com.pokedex.illustratedbook.model.Version
import com.pokedex.illustratedbook.model.VersionGroup
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
  // region Resource Lists

  // region Berries

  @GET("berry/")
  suspend fun getBerryList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<NamedApiResourceList>

  @GET("berry-firmness/")
  suspend fun getBerryFirmnessList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<NamedApiResourceList>

  @GET("berry-flavor/")
  suspend fun getBerryFlavorList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<NamedApiResourceList>

  // endregion Berries

  // region Contests

  @GET("contest-type/")
  suspend fun getContestTypeList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<NamedApiResourceList>

  @GET("contest-effect/")
  suspend fun getContestEffectList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<ApiResourceList>

  @GET("super-contest-effect/")
  suspend fun getSuperContestEffectList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<ApiResourceList>

  // endregion Contests

  // region Encounters

  @GET("encounter-method/")
  suspend fun getEncounterMethodList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<NamedApiResourceList>

  @GET("encounter-condition/")
  suspend fun getEncounterConditionList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<NamedApiResourceList>

  @GET("encounter-condition-value/")
  suspend fun getEncounterConditionValueList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<NamedApiResourceList>

  // endregion

  // region Evolution

  @GET("evolution-chain/")
  suspend fun getEvolutionChainList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<ApiResourceList>

  @GET("evolution-trigger/")
  suspend fun getEvolutionTriggerList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<NamedApiResourceList>

  // endregion

  //region Games

  @GET("generation/")
  suspend fun getGenerationList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<NamedApiResourceList>

  @GET("pokedex/")
  suspend fun getPokedexList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<NamedApiResourceList>

  @GET("version/")
  suspend fun getVersionList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<NamedApiResourceList>

  @GET("version-group/")
  suspend fun getVersionGroupList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<NamedApiResourceList>

  // endregion

  // region Items

  @GET("item/")
  suspend fun getItemList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<NamedApiResourceList>

  @GET("item-attribute/")
  suspend fun getItemAttributeList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<NamedApiResourceList>

  @GET("item-category/")
  suspend fun getItemCategoryList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<NamedApiResourceList>

  @GET("item-fling-effect/")
  suspend fun getItemFlingEffectList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<NamedApiResourceList>

  @GET("item-pocket/")
  suspend fun getItemPocketList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<NamedApiResourceList>

  // endregion

  //region Moves

  @GET("move/")
  suspend fun getMoveList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<NamedApiResourceList>

  @GET("move-ailment/")
  suspend fun getMoveAilmentList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<NamedApiResourceList>

  @GET("move-battle-style/")
  suspend fun getMoveBattleStyleList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<NamedApiResourceList>

  @GET("move-category/")
  suspend fun getMoveCategoryList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<NamedApiResourceList>

  @GET("move-damage-class/")
  suspend fun getMoveDamageClassList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<NamedApiResourceList>

  @GET("move-learn-method/")
  suspend fun getMoveLearnMethodList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<NamedApiResourceList>

  @GET("move-target/")
  suspend fun getMoveTargetList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<NamedApiResourceList>

  // endregion

  // region Locations

  @GET("location/")
  suspend fun getLocationList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<NamedApiResourceList>

  @GET("location-area/")
  suspend fun getLocationAreaList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<NamedApiResourceList>

  @GET("pal-park-area/")
  suspend fun getPalParkAreaList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<NamedApiResourceList>

  @GET("region/")
  suspend fun getRegionList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<NamedApiResourceList>

  // endregion

  // region Machines

  @GET("machine/")
  suspend fun getMachineList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<ApiResourceList>

  // endregion

  // region Pokemon

  @GET("ability/")
  suspend fun getAbilityList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<NamedApiResourceList>

  @GET("characteristic/")
  suspend fun getCharacteristicList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<ApiResourceList>

  @GET("egg-group/")
  suspend fun getEggGroupList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<NamedApiResourceList>

  @GET("gender/")
  suspend fun getGenderList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<NamedApiResourceList>

  @GET("growth-rate/")
  suspend fun getGrowthRateList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<NamedApiResourceList>

  @GET("nature/")
  suspend fun getNatureList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<NamedApiResourceList>

  @GET("pokeathlon-stat/")
  suspend fun getPokeathlonStatList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<NamedApiResourceList>

  @GET("pokemon/")
  suspend fun getPokemonList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<NamedApiResourceList>

  @GET("pokemon-color/")
  suspend fun getPokemonColorList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<NamedApiResourceList>

  @GET("pokemon-form/")
  suspend fun getPokemonFormList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<NamedApiResourceList>

  @GET("pokemon-habitat/")
  suspend fun getPokemonHabitatList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<NamedApiResourceList>

  @GET("pokemon-shape/")
  suspend fun getPokemonShapeList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<NamedApiResourceList>

  @GET("pokemon-species/")
  suspend fun getPokemonSpeciesList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<NamedApiResourceList>

  @GET("stat/")
  suspend fun getStatList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<NamedApiResourceList>

  @GET("type/")
  suspend fun getTypeList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<NamedApiResourceList>

  // endregion

  // region Utility

  @GET("language/")
  suspend fun getLanguageList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): Response<NamedApiResourceList>

  // endregion

  // endregion

  // region Berries

  @GET("berry/{id}/")
  suspend fun getBerry(@Path("id") id: Int): Response<Berry>

  @GET("berry-firmness/{id}/")
  suspend fun getBerryFirmness(@Path("id") id: Int): Response<BerryFirmness>

  @GET("berry-flavor/{id}/")
  suspend fun getBerryFlavor(@Path("id") id: Int): Response<BerryFlavor>

  // endregion Berries

  // region Contests

  @GET("contest-type/{id}/")
  suspend fun getContestType(@Path("id") id: Int): Response<ContestType>

  @GET("contest-effect/{id}/")
  suspend fun getContestEffect(@Path("id") id: Int): Response<ContestEffect>

  @GET("super-contest-effect/{id}/")
  suspend fun getSuperContestEffect(@Path("id") id: Int): Response<SuperContestEffect>

  // endregion Contests

  // region Encounters

  @GET("encounter-method/{id}/")
  suspend fun getEncounterMethod(@Path("id") id: Int): Response<EncounterMethod>

  @GET("encounter-condition/{id}/")
  suspend fun getEncounterCondition(@Path("id") id: Int): Response<EncounterCondition>

  @GET("encounter-condition-value/{id}/")
  suspend fun getEncounterConditionValue(@Path("id") id: Int): Response<EncounterConditionValue>

  // endregion Contests

  // region Evolution

  @GET("evolution-chain/{id}/")
  suspend fun getEvolutionChain(@Path("id") id: Int): Response<EvolutionChain>

  @GET("evolution-trigger/{id}/")
  suspend fun getEvolutionTrigger(@Path("id") id: Int): Response<EvolutionTrigger>

  // endregion Evolution

  // region Games

  @GET("generation/{id}/")
  suspend fun getGeneration(@Path("id") id: Int): Response<Generation>

  @GET("pokedex/{id}/")
  suspend fun getPokedex(@Path("id") id: Int): Response<Pokedex>

  @GET("version/{id}/")
  suspend fun getVersion(@Path("id") id: Int): Response<Version>

  @GET("version-group/{id}/")
  suspend fun getVersionGroup(@Path("id") id: Int): Response<VersionGroup>

  // endregion Games

  // region Items

  @GET("item/{id}/")
  suspend fun getItem(@Path("id") id: Int): Response<Item>

  @GET("item-attribute/{id}/")
  suspend fun getItemAttribute(@Path("id") id: Int): Response<ItemAttribute>

  @GET("item-category/{id}/")
  suspend fun getItemCategory(@Path("id") id: Int): Response<ItemCategory>

  @GET("item-fling-effect/{id}/")
  suspend fun getItemFlingEffect(@Path("id") id: Int): Response<ItemFlingEffect>

  @GET("item-pocket/{id}/")
  suspend fun getItemPocket(@Path("id") id: Int): Response<ItemPocket>

  // endregion Items

  // region Moves

  @GET("move/{id}/")
  suspend fun getMove(@Path("id") id: Int): Response<Move>

  @GET("move-ailment/{id}/")
  suspend fun getMoveAilment(@Path("id") id: Int): Response<MoveAilment>

  @GET("move-battle-style/{id}/")
  suspend fun getMoveBattleStyle(@Path("id") id: Int): Response<MoveBattleStyle>

  @GET("move-category/{id}/")
  suspend fun getMoveCategory(@Path("id") id: Int): Response<MoveCategory>

  @GET("move-damage-class/{id}/")
  suspend fun getMoveDamageClass(@Path("id") id: Int): Response<MoveDamageClass>

  @GET("move-learn-method/{id}/")
  suspend fun getMoveLearnMethod(@Path("id") id: Int): Response<MoveLearnMethod>

  @GET("move-target/{id}/")
  suspend fun getMoveTarget(@Path("id") id: Int): Response<MoveTarget>

  // endregion Moves

  // region Locations

  @GET("location/{id}/")
  suspend fun getLocation(@Path("id") id: Int): Response<Location>

  @GET("location-area/{id}/")
  suspend fun getLocationArea(@Path("id") id: Int): Response<LocationArea>

  @GET("pal-park-area/{id}/")
  suspend fun getPalParkArea(@Path("id") id: Int): Response<PalParkArea>

  @GET("region/{id}/")
  suspend fun getRegion(@Path("id") id: Int): Response<Region>

  // endregion Locations

  // region Machines

  @GET("machine/{id}/")
  suspend fun getMachine(@Path("id") id: Int): Response<Machine>

  // endregion

  // region Pokemon

  @GET("ability/{id}/")
  suspend fun getAbility(@Path("id") id: Int): Response<Ability>

  @GET("characteristic/{id}/")
  suspend fun getCharacteristic(@Path("id") id: Int): Response<Characteristic>

  @GET("egg-group/{id}/")
  suspend fun getEggGroup(@Path("id") id: Int): Response<EggGroup>

  @GET("gender/{id}/")
  suspend fun getGender(@Path("id") id: Int): Response<Gender>

  @GET("growth-rate/{id}/")
  suspend fun getGrowthRate(@Path("id") id: Int): Response<GrowthRate>

  @GET("nature/{id}/")
  suspend fun getNature(@Path("id") id: Int): Response<Nature>

  @GET("pokeathlon-stat/{id}/")
  suspend fun getPokeathlonStat(@Path("id") id: Int): Response<PokeathlonStat>

  @GET("pokemon/{id}/")
  suspend fun getPokemon(@Path("id") id: Int): Response<Pokemon>

  @GET("pokemon/{id}/encounters/")
  suspend fun getPokemonEncounterList(@Path("id") id: Int): Response<List<LocationAreaEncounter>>

  @GET("pokemon-color/{id}/")
  suspend fun getPokemonColor(@Path("id") id: Int): Response<PokemonColor>

  @GET("pokemon-form/{id}/")
  suspend fun getPokemonForm(@Path("id") id: Int): Response<PokemonForm>

  @GET("pokemon-habitat/{id}/")
  suspend fun getPokemonHabitat(@Path("id") id: Int): Response<PokemonHabitat>

  @GET("pokemon-shape/{id}/")
  suspend fun getPokemonShape(@Path("id") id: Int): Response<PokemonShape>

  @GET("pokemon-species/{id}/")
  suspend fun getPokemonSpecies(@Path("id") id: Int): Response<PokemonSpecies>

  @GET("stat/{id}/")
  suspend fun getStat(@Path("id") id: Int): Response<Stat>

  @GET("type/{id}/")
  suspend fun getType(@Path("id") id: Int): Response<Type>

  // endregion Pokemon

  // region Utility

  @GET("language/{id}/")
  suspend fun getLanguage(@Path("id") id: Int): Response<Language>

  // endregion Utility
}