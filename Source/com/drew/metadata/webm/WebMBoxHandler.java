package com.drew.metadata.webm;

import com.drew.imaging.webm.WebMHandler;
import com.drew.metadata.Metadata;
import com.drew.metadata.mp4.boxes.Box;

import java.io.IOException;

/**
 * @author Artem Klyuev
 */
public class WebMBoxHandler extends WebMHandler<WebMDirectory>
{
    private WebMHandlerFactory handlerFactory = new WebMHandlerFactory(this);

    public WebMBoxHandler(Metadata metadata)
    {
        super(metadata);
    }

    @Override
    protected WebMDirectory getDirectory() {
        return new WebMDirectory();
    }

    @Override
    protected boolean shouldAcceptBox(Box box) {
        return false;
    }

    @Override
    protected boolean shouldAcceptContainer(Box box) {
        return false;
    }

    @Override
    protected WebMHandler<?> processBox(Box box, byte[] payload, WebMContext context) throws IOException {
        return this;
    }
}
