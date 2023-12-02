package com.fylora.watermyplants.core.di

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Room
import com.fylora.watermyplants.core.Commons.DATABASE_NAME
import com.fylora.watermyplants.data.data_sources.PlantsDatabase
import com.fylora.watermyplants.data.repository.PlantsRepositoryImpl
import com.fylora.watermyplants.domain.repository.PlantsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application): PlantsDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = PlantsDatabase::class.java,
            name = DATABASE_NAME
        ).build()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @Provides
    @Singleton
    fun providePlantsRepository(database: PlantsDatabase): PlantsRepository {
        return PlantsRepositoryImpl(
            plantsDao = database.plantsDao,
            plantNotificationsDao = database.plantNotificationDao
        )
    }
}