package com.example.financefit;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    private static final int PICK_IMAGE_REQUEST = 1;
    private static final int PERMISSION_REQUEST_CODE = 100;

    private static final String PERMISSION_DENIED_MESSAGE = "Permission denied. Cannot open gallery.";
    private static final String ERROR_RETRIEVING_IMAGE_MESSAGE = "Error: Unable to retrieve image.";
    private static final String FILL_IN_ALL_FIELDS_MESSAGE = "Please fill in all required fields.";

    private ImageView profileImage;
    private Button updateProfileButton;
    private EditText profileName;
    private EditText phoneNumber;
    private EditText email;
    private EditText location;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Reference the elements in the layout
        profileImage = view.findViewById(R.id.profile_img);
        updateProfileButton = view.findViewById(R.id.update);
        profileName = view.findViewById(R.id.profile_name);
        phoneNumber = view.findViewById(R.id.phone_number);
        email = view.findViewById(R.id.e_mail);
        location = view.findViewById(R.id.location);

        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hasPermission()) {
                    openGallery();
                } else {
                    requestPermission();
                }
            }
        });

        updateProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateFields()) {
                    openProfileActivity();
                } else {
                    Toast.makeText(getContext(), FILL_IN_ALL_FIELDS_MESSAGE, Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    private boolean validateFields() {
        // Check if any required fields are empty
        return !profileName.getText().toString().isEmpty() &&
                !phoneNumber.getText().toString().isEmpty() &&
                !email.getText().toString().isEmpty() &&
                !location.getText().toString().isEmpty();
    }

    private void openProfileActivity() {
        Intent intent = new Intent(getActivity(), profile1.class);
        startActivity(intent);
    }


    private boolean hasPermission() {
        return ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), Manifest.permission.READ_EXTERNAL_STORAGE)) {
            Toast.makeText(getContext(), "Permission is needed to access your gallery.", Toast.LENGTH_SHORT).show();
        }
        ActivityCompat.requestPermissions(
                requireActivity(),
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                PERMISSION_REQUEST_CODE
        );
    }

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setDataAndType(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == requireActivity().RESULT_OK && data!= null) {
            Uri selectedImageUri = data.getData();
            if (selectedImageUri!= null) {
                profileImage.setImageURI(selectedImageUri);  // Set the image to the ImageView
            } else {
                Toast.makeText(getContext(), ERROR_RETRIEVING_IMAGE_MESSAGE, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openGallery();  // Permission granted, open the gallery
            } else {
                Toast.makeText(getContext(), PERMISSION_DENIED_MESSAGE, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
