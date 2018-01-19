package com.zgodnji.fifastattracker;

import com.kumuluz.ee.discovery.annotations.DiscoverService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@RequestScoped
@Path("user-stats")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserStatResource {

    @GET
    public Response getAllUserStats() {
        List<UserStat> stats = Database.getUserStats();
        return Response.ok(stats).build();
    }

    @GET
    @Path("{userId}")
    public Response getUserStat(@PathParam("userId") String userId) {
        UserStat stat = Database.getUserStat(userId);
        return stat != null
                ? Response.ok(stat).build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    public Response addNewUserStat(UserStat stat) {
        Database.addUserStat(stat);
        return Response.noContent().build();
    }

    @DELETE
    @Path("{userId}")
    public Response deleteUserStat(@PathParam("userId") String userId) {
        Database.deleteUserStat(userId);
        return Response.noContent().build();
    }

    @GET
    @Path("create")
    public Response fillDatabse() {
        Database.addUserStat(new UserStat(
                "1",
                0.8,
                5,
                4,
                1
        ));
        Database.addUserStat(new UserStat(
                "2",
                0.0,
                0,
                0,
                0
        ));
        return Response.noContent().build();
    }

    @Inject
    private UserStatProperties properties;

    @GET
    @Path("config")
    public Response getConfig() {
        String response =
                "{" +
                        "\"stringProperty\": \"%s\"," +
                        "\"booleanProperty\": %b," +
                        "\"integerProperty\": %d" +
                        "}";

        response = String.format(
                response,
                properties.getStringProperty(),
                properties.getBooleanProperty(),
                properties.getIntegerProperty());

        return Response.ok(response).build();
    }

}
