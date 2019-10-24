package ru.academits.servlet;

import ru.academits.PhoneBook;
import ru.academits.service.ContactService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

public class DeleteContactServlet extends HttpServlet {
    private ContactService contactService = PhoneBook.contactService;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String contactId = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        contactService.deleteContact(Integer.parseInt(contactId.substring(contactId.lastIndexOf("=") + 1)));
        resp.sendRedirect("/phonebook");
    }
}
