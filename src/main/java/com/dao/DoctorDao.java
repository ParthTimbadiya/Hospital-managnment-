package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Doctor;

public class DoctorDao {

	private Connection con;

	public DoctorDao(Connection con) {
		super();
		this.con = con;
	}

	public boolean registerDoctor(Doctor d) {

		boolean f = false;

		try {

			String sql = "insert into doctor(fullName, dob, qualification, specialist, email, mono, password) values(?,?,?,?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, d.getFullName());
			ps.setString(2, d.getDob());
			ps.setString(3, d.getQualification());
			ps.setString(4, d.getSpecialist());
			ps.setString(5, d.getEmail());
			ps.setString(6, d.getMobNo());
			ps.setString(7, d.getPassword());

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;

	}

	public List<Doctor> getAllDoctor() {

		List<Doctor> list = new ArrayList<Doctor>();

		Doctor doctor = null;

		try {

			String sql = "select * from doctor order by id desc";

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				doctor = new Doctor();

				doctor.setId(rs.getInt(1));
				doctor.setFullName(rs.getString(2));
				doctor.setDob(rs.getString(3));
				doctor.setQualification(rs.getString(4));
				doctor.setSpecialist(rs.getString(5));
				doctor.setEmail(rs.getString(6));
				doctor.setMobNo(rs.getString(7));
				doctor.setPassword(rs.getString(8));

				list.add(doctor);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public Doctor getDoctorById(int id) {

		Doctor doctor = null;

		try {

			String sql = "select * from doctor where id=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				doctor = new Doctor();

				doctor.setId(rs.getInt(1));
				doctor.setFullName(rs.getString(2));
				doctor.setDob(rs.getString(3));
				doctor.setQualification(rs.getString(4));
				doctor.setSpecialist(rs.getString(5));
				doctor.setEmail(rs.getString(6));
				doctor.setMobNo(rs.getString(7));
				doctor.setPassword(rs.getString(8));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return doctor;
	}

	public boolean updateDoctor(Doctor d) {

		boolean f = false;

		try {

			String sql = "update doctor set fullName=?, dob=?, qualification=?, specialist=?, email=?, mono=?, password=? where id=?";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, d.getFullName());
			ps.setString(2, d.getDob());
			ps.setString(3, d.getQualification());
			ps.setString(4, d.getSpecialist());
			ps.setString(5, d.getEmail());
			ps.setString(6, d.getMobNo());
			ps.setString(7, d.getPassword());
			ps.setInt(8, d.getId());

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;

	}
	
	
	public boolean deletDoctor(int id) {
		boolean f = false;
		
		try {
			
			String sql = "delete from doctor where id=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			int i = ps.executeUpdate();
			
			if(i == 1) {
				f = true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return f;
	}
	
	
	public Doctor login(String email, String password) {
		
		Doctor d = null;
		
		try {
			
			String sql = "select * from doctor where email=? and password=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				d = new Doctor();

				d.setId(rs.getInt(1));
				d.setFullName(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setQualification(rs.getString(4));
				d.setSpecialist(rs.getString(5));
				d.setEmail(rs.getString(6));
				d.setMobNo(rs.getString(7));
				d.setPassword(rs.getString(8));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return d;
	}
	
	
	public int countDoctor() {
		int i = 0;
		
		
		try {
			
			String sql = "select * from doctor";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				i++;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return i;
	}
	
	
	public int countAppoinment() {
		int i = 0;
		
		
		try {
			
			String sql = "select * from appointment";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				i++;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return i;
	}
	
	public int countUser() {
		int i = 0;
		
		
		try {
			
			String sql = "select * from user_details";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				i++;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return i;
	}
	
	
	public int countSpecialist() {
		int i = 0;
		
		
		try {
			
			String sql = "select * from specialist";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				i++;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return i;
	}
	
	
	
	
	public int countAppoinmentByDoctorId(int did) {
		int i = 0;
		
		
		try {
			
			String sql = "select * from appointment where doctor_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, did);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				i++;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return i;
	}
	
	
	
	public boolean checkOldPassword(int userId, String oldPassword) {

		boolean f = false;

		try {

			String sql = "select * from doctor where id=? and password=?";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setString(2, oldPassword);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;

	}

	public boolean changePassword(int userId, String newPassword) {

		boolean f = false;

		try {

			String sql = "update doctor set password=? where id=?";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newPassword);
			ps.setInt(2, userId);
			int i = ps.executeUpdate();

			if(i== 1) {
				f=true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;

	}
	
	public boolean editDoctorProfile(Doctor d) {

		boolean f = false;

		try {

			String sql = "update doctor set fullName=?, dob=?, qualification=?, specialist=?, email=?, mono=? where id=?";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, d.getFullName());
			ps.setString(2, d.getDob());
			ps.setString(3, d.getQualification());
			ps.setString(4, d.getSpecialist());
			ps.setString(5, d.getEmail());
			ps.setString(6, d.getMobNo());
			ps.setInt(7, d.getId());

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;

	}

	

}
