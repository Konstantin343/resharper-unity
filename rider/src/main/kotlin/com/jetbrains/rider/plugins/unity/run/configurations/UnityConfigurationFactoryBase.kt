package com.jetbrains.rider.plugins.unity.run.configurations

import com.intellij.execution.configurations.ConfigurationType
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.openapi.project.Project
import com.jetbrains.rider.isUnityClassLibraryProject
import com.jetbrains.rider.isUnityProjectFolder
import com.jetbrains.rider.run.configurations.DotNetConfigurationFactoryBase

abstract class UnityConfigurationFactoryBase(type: ConfigurationType)
    : DotNetConfigurationFactoryBase<RunConfiguration>(type) {

    // Push this factory into the "Other" section if we're not in some kind of Unity project - either in a Unity project
    // folder (generated solution or otherwise), or we've got a Unity reference. This just de-prioritises the
    // configuration factory in the list of new configuration types. You can still create and use configurations
    override fun isApplicable(project: Project): Boolean {
        return super.isApplicable(project) && (project.isUnityProjectFolder() || project.isUnityClassLibraryProject() == true)
    }
}