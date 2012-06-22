package org.alia4j.liam;

/**
 * @author Andreas Sewe, Christoph Bockisch
 */
public final class DebugInfo {
    
    public static final String UNKNOWN_FILE = null;
    
    public static final int UNKNOWN_LINE_NUMBER = -1;
    
    public static final int UNKNOWN_OFFSET = -1;
    
    public static final DebugInfo UNKNOWN_INFO = new DebugInfo(DebugInfo.UNKNOWN_FILE);
    
    /**
     * The file name (relative to the compilation root) from which an entity has been compiled.
     */
    public final String fileName;
    
    /**
     * The position within the file. -1 for a value means unspecified.
     */
    public final int startLine, startOffset, endLine, endOffset;
    
    /**
     * The String from the source file which corresponds to the specified range (or an empty String).
     */
    public String sourceString;
    
    public DebugInfo(String fileName) {
        this(fileName, DebugInfo.UNKNOWN_LINE_NUMBER, DebugInfo.UNKNOWN_OFFSET, DebugInfo.UNKNOWN_LINE_NUMBER,
                        DebugInfo.UNKNOWN_OFFSET, "");
    }
    
    public DebugInfo(String fileName, String sourceString) {
        this(fileName, DebugInfo.UNKNOWN_LINE_NUMBER, DebugInfo.UNKNOWN_OFFSET, DebugInfo.UNKNOWN_LINE_NUMBER,
                        DebugInfo.UNKNOWN_OFFSET, sourceString);
    }
    
    public DebugInfo(String fileName, int line) {
        this(fileName, line, DebugInfo.UNKNOWN_OFFSET, line, DebugInfo.UNKNOWN_OFFSET, "");
    }
    
    public DebugInfo(String fileName, int startLine, int endLine) {
        this(fileName, startLine, DebugInfo.UNKNOWN_OFFSET, endLine, DebugInfo.UNKNOWN_OFFSET, "");
    }
    
    public DebugInfo(String fileName, int line, String sourceString) {
        this(fileName, line, DebugInfo.UNKNOWN_OFFSET, line, DebugInfo.UNKNOWN_OFFSET, sourceString);
    }
    
    public DebugInfo(String fileName, int startLine, int startOffset, int endLine, int endOffset) {
        this(fileName, startLine, startOffset, endLine, endOffset, "");
    }
    
    public DebugInfo(String fileName, int startLine, int startOffset, int endLine, int endOffset, String sourceString) {
        if (startLine < 0 && endLine < 0) {
            if (startOffset >= 0 || endOffset >= 0)
                throw new IllegalArgumentException(
                                "If start line and end line are < 0 (undefined), start and end offset must also be < 0 (undefined).");
        } else if (startLine < 0 || endLine < 0)
            throw new IllegalArgumentException(
                            "Either both start and end line are negative (i.e., undefined) or both must be >= 0 (i.e., defined).");
        else if (endLine < startLine || (startLine == endLine && endOffset < startOffset))
            throw new IllegalArgumentException("Illegal range; start must be <= end.");
        else if ((startOffset < 0 && endOffset >= 0) || (startOffset >= 0 && endOffset < 0))
            throw new IllegalArgumentException("Either start and end offset must both be undefined (<0) or defined (>=0).");
        
        if (startLine >= 0 && fileName == null)
            throw new IllegalArgumentException("fileName may not be null when a position within a file is specified.");
        this.fileName = fileName;
        this.startLine = startLine < 0 ? DebugInfo.UNKNOWN_LINE_NUMBER : startLine;
        this.startOffset = startOffset < 0 ? DebugInfo.UNKNOWN_OFFSET : startOffset;
        this.endLine = endLine < 0 ? DebugInfo.UNKNOWN_LINE_NUMBER : endLine;
        this.endOffset = endOffset < 0 ? DebugInfo.UNKNOWN_OFFSET : endOffset;
        this.sourceString = sourceString == null ? "" : sourceString;
    }
    
    public String getSourceString() {
        return this.sourceString;
    }
    
    public String getFileName() {
        return this.fileName;
    }
    
    public int getFirstLineNumber() {
        return this.endLine;
    }
    
    public int getLastLineNumber() {
        return this.startLine;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.endLine;
        result = prime * result + this.endOffset;
        result = prime * result + ((this.fileName == null) ? 0 : this.fileName.hashCode());
        result = prime * result + ((this.sourceString == null) ? 0 : this.sourceString.hashCode());
        result = prime * result + this.startLine;
        result = prime * result + this.startOffset;
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        DebugInfo other = (DebugInfo) obj;
        if (this.endLine != other.endLine)
            return false;
        if (this.endOffset != other.endOffset)
            return false;
        if (this.fileName == null) {
            if (other.fileName != null)
                return false;
        } else if (!this.fileName.equals(other.fileName))
            return false;
        if (this.sourceString == null) {
            if (other.sourceString != null)
                return false;
        } else if (!this.sourceString.equals(other.sourceString))
            return false;
        if (this.startLine != other.startLine)
            return false;
        if (this.startOffset != other.startOffset)
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        return "DebugInfo [fileName=" + this.fileName + ", startLine=" + this.startLine + ", startOffset="
                        + this.startOffset + ", endLine=" + this.endLine + ", endOffset=" + this.endOffset
                        + ", sourceString=" + this.sourceString + "]";
    }
    
    @Deprecated
    public void setSourceString(String text) {
        this.sourceString = text == null ? "" : text;
    }
    
}
