package org.alia4j.liam;

public class ImplicitAttachmentReference implements AttachmentReference {
    
    public static ImplicitAttachmentReference INSTANCE = new ImplicitAttachmentReference();
    
    private ImplicitAttachmentReference() {}
    
    @Override
    public boolean references(Attachment attachment) {
        return attachment.getScheduleInfo().getRule() == ScheduleRule.IMPLICIT_ACTION;
    }
    
}
