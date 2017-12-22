/*
 * Copyright 2017 ThoughtWorks, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.thoughtworks.go.plugin.access.analytics.models;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.StringUtils;

public class AnalyticsData {
    private static final Gson GSON = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    @Expose
    @SerializedName("data")
    String data;

    @Expose
    @SerializedName("view_path")
    String viewPath;

    public String getData() {
        return data;
    }

    public String getViewPath() {
        return viewPath;
    }

    public static AnalyticsData fromJSON(String json) {
        return GSON.fromJson(json, AnalyticsData.class);
    }

    public com.thoughtworks.go.plugin.domain.analytics.AnalyticsData toAnalyticsData() {
        return new com.thoughtworks.go.plugin.domain.analytics.AnalyticsData(data, viewPath);
    }

    public boolean isValid() {
        return (!StringUtils.isBlank(data) && !StringUtils.isBlank(viewPath));
    }
}