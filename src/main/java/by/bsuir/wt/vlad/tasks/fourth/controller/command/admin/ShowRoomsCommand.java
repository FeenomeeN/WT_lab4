package by.bsuir.wt.vlad.tasks.fourth.controller.command.admin;

import by.bsuir.wt.vlad.tasks.fourth.controller.command.Command;
import by.bsuir.wt.vlad.tasks.fourth.controller.command.CommandResult;
import by.bsuir.wt.vlad.tasks.fourth.entity.Room;
import by.bsuir.wt.vlad.tasks.fourth.exception.ServiceException;
import by.bsuir.wt.vlad.tasks.fourth.service.RoomService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowRoomsCommand implements Command {
    private static final String ROOMS_PAGE = "/WEB-INF/pages/admin/rooms.jsp";
    private static final String ROOM_LIST = "roomList";
    private static final String MESSAGE = "message";
    private static final String NOTIFY_MESSAGE = "notifyMessage";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        RoomService roomService = new RoomService();
        List<Room> fullRoomList = roomService.findAll();
        request.setAttribute(ROOM_LIST, fullRoomList);

        String notifyMessage = request.getParameter(MESSAGE);
        if (notifyMessage != null) {
            request.setAttribute(NOTIFY_MESSAGE, notifyMessage);
        }

        return CommandResult.forward(ROOMS_PAGE);
    }
}
