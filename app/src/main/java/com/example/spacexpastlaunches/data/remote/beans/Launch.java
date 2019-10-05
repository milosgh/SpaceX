package com.example.spacexpastlaunches.data.remote.beans;

import com.google.gson.annotations.SerializedName;

/**
 * Created by milospesic on 10/05/19.
 */
public class Launch {

    @SerializedName("mission_name")
    String missionName;

    @SerializedName("launch_date_unix")
    String launchDateUnix;

    @SerializedName("launch_site")
    LaunchSite launchSite;

    @SerializedName("launch_success")
    boolean launchSuccess;

    Link links;

    public static class LaunchSite {
        @SerializedName("site_name")
        String siteName;

        public String getSiteName() {
            return siteName;
        }

        @Override
        public String toString() {
            return "LaunchSite{" +
                    "siteName='" + siteName + '\'' +
                    '}';
        }
    }

    public static class Link {
        @SerializedName("mission_patch")
        String missionPatch;

        public String getMissionPatch() {
            return missionPatch;
        }

        @Override
        public String toString() {
            return "Link{" +
                    "missionPatch='" + missionPatch + '\'' +
                    '}';
        }
    }

    public String getMissionName() {
        return missionName;
    }

    public String getLaunchDateUnix() {
        return launchDateUnix;
    }

    public LaunchSite getLaunchSite() {
        return launchSite;
    }

    public boolean isLaunchSuccess() {
        return launchSuccess;
    }

    public Link getLinks() {
        return links;
    }

    @Override
    public String toString() {
        return "Launch{" +
                "missionName='" + missionName + '\'' +
                ", launchDateUnix='" + launchDateUnix + '\'' +
                ", launchSite=" + launchSite +
                ", launchSuccess=" + launchSuccess +
                ", links=" + links +
                '}';
    }
}
