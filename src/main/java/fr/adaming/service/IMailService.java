package fr.adaming.service;

public interface IMailService {
	
	public int sendMail(String destinataire, String message) throws Exception;
	
	public int sendMailDeux(String destinataire, String message) throws Exception;

}
