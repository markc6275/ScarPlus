package com.esotericsoftware.filesystem;

import java.io.*;

import com.esotericsoftware.scar.*;

public final class FilePath
{
    private final File mSomeParentDir;
    private final String mFileSubPath;
    private final File mCanonicalPath;

    private FilePath( File pSomeParentDir, String pFileSubPath, File pCanonicalPath )
    {
        mSomeParentDir = pSomeParentDir;
        mFileSubPath = pFileSubPath;
        mCanonicalPath = pCanonicalPath;
    }

    public FilePath( File pSomeParentDir, String pFileSubPath )
    {
        this( pSomeParentDir, pFileSubPath, Utils.canonical( new File( pSomeParentDir, pFileSubPath ) ) );
    }

    public static FilePath canonical( File pSomeParentDir, String pFileSubPath )
    {
        return new FilePath( pSomeParentDir, pFileSubPath, new File( pSomeParentDir, pFileSubPath ) );
    }

    public File getSomeParentDir()
    {
        return mSomeParentDir;
    }

    public String getFileSubPath()
    {
        return mFileSubPath;
    }

    public String canonical()
    {
        return mCanonicalPath.getPath();
    }

    public File file()
    {
        return mCanonicalPath;
    }

    public boolean equals( FilePath them )
    {
        return this == them || ((them != null) && this.canonical().equals( them.canonical() ));
    }

    public boolean equals( Object obj )
    {
        return (this == obj) || ((obj instanceof FilePath) && equals( (FilePath) obj ));
    }

    public int hashCode()
    {
        return canonical().hashCode();
    }
}
