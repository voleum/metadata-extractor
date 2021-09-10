package com.drew.imaging.webm;

import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import com.drew.metadata.Metadata;
import com.drew.metadata.mp4.boxes.Box;
import com.drew.metadata.webm.WebMContext;
import com.drew.metadata.webm.WebMDirectory;

import java.io.IOException;

/**
 * @author Artem Klyuev
 */
public abstract class WebMHandler<T extends WebMDirectory> {

    @NotNull
    protected Metadata metadata;
    @NotNull protected T directory;

    public WebMHandler(@NotNull Metadata metadata)
    {
        this.metadata = metadata;
        this.directory = getDirectory();
        metadata.addDirectory(directory);
    }

    @NotNull
    protected abstract T getDirectory();

    protected abstract boolean shouldAcceptBox(@NotNull Box box);

    protected abstract boolean shouldAcceptContainer(@NotNull Box box);

    protected abstract WebMHandler<?> processBox(@NotNull Box box, @Nullable byte[] payload, WebMContext context) throws IOException;

    protected WebMHandler<?> processContainer(@NotNull Box box, @NotNull WebMContext context) throws IOException
    {
        return processBox(box, null, context);
    }

    public void addError(@NotNull String message)
    {
        directory.addError(message);
    }
}
