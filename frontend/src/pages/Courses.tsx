import React, { useState, useEffect } from 'react';
import {
  Box,
  Card,
  CardContent,
  Typography,
  Button,
  Grid,
  Chip,
  IconButton,
  Dialog,
  DialogTitle,
  DialogContent,
  DialogActions,
  TextField,
  FormControl,
  InputLabel,
  Select,
  MenuItem,
} from '@mui/material';
import {
  Add,
  Edit,
  Delete,
  School,
  Book,
  People,
  AttachMoney,
} from '@mui/icons-material';
import api from '../services/api';
import { toast } from 'react-toastify';

interface Course {
  id: number;
  courseCode: string;
  courseName: string;
  description: string;
  durationYears: number;
  totalFees: number;
  department: string;
  isActive: boolean;
}

const Courses: React.FC = () => {
  const [courses, setCourses] = useState<Course[]>([]);
  // const [loading, setLoading] = useState(true); // Removed unused variable
  const [open, setOpen] = useState(false);
  const [editingCourse, setEditingCourse] = useState<Course | null>(null);

  useEffect(() => {
    fetchCourses();
  }, []);

  const fetchCourses = async () => {
    try {
      const response = await api.get('/courses');
      setCourses(response.data.data);
    } catch (error) {
      toast.error('Error fetching courses');
    } finally {
      // setLoading(false); // Removed unused variable
    }
  };

  const handleAddCourse = () => {
    setEditingCourse(null);
    setOpen(true);
  };

  const handleEditCourse = (course: Course) => {
    setEditingCourse(course);
    setOpen(true);
  };

  const handleDeleteCourse = async (id: number) => {
    if (window.confirm('Are you sure you want to delete this course?')) {
      try {
        await api.delete(`/courses/${id}`);
        toast.success('Course deleted successfully');
        fetchCourses();
      } catch (error) {
        toast.error('Error deleting course');
      }
    }
  };

  const handleClose = () => {
    setOpen(false);
    setEditingCourse(null);
  };

  const CourseCard: React.FC<{ course: Course }> = ({ course }) => (
    <Card sx={{ height: '100%', display: 'flex', flexDirection: 'column' }}>
      <CardContent sx={{ flexGrow: 1 }}>
        <Box display="flex" justifyContent="space-between" alignItems="flex-start" mb={2}>
          <Box>
            <Typography variant="h6" component="h2" gutterBottom>
              {course.courseName}
            </Typography>
            <Typography variant="body2" color="text.secondary" gutterBottom>
              {course.courseCode}
            </Typography>
          </Box>
          <Box>
            <IconButton onClick={() => handleEditCourse(course)}>
              <Edit />
            </IconButton>
            <IconButton onClick={() => handleDeleteCourse(course.id)} color="error">
              <Delete />
            </IconButton>
          </Box>
        </Box>
        
        <Typography variant="body2" color="text.secondary" paragraph>
          {course.description}
        </Typography>
        
        <Box display="flex" flexWrap="wrap" gap={1} mb={2}>
          <Chip
            icon={<School />}
            label={course.department}
            color="primary"
            variant="outlined"
            size="small"
          />
          <Chip
            icon={<Book />}
            label={`${course.durationYears} Years`}
            color="secondary"
            variant="outlined"
            size="small"
          />
          <Chip
            icon={<AttachMoney />}
            label={`$${course.totalFees.toLocaleString()}`}
            color="success"
            variant="outlined"
            size="small"
          />
        </Box>
        
        <Box display="flex" alignItems="center" justifyContent="space-between">
          <Chip
            label={course.isActive ? 'Active' : 'Inactive'}
            color={course.isActive ? 'success' : 'error'}
            size="small"
          />
          <Button
            variant="outlined"
            size="small"
            startIcon={<People />}
          >
            View Students
          </Button>
        </Box>
      </CardContent>
    </Card>
  );

  return (
    <Box>
      <Box display="flex" justifyContent="space-between" alignItems="center" mb={3}>
        <Typography variant="h4">Courses</Typography>
        <Button
          variant="contained"
          startIcon={<Add />}
          onClick={handleAddCourse}
        >
          Add Course
        </Button>
      </Box>

      <Grid container spacing={3}>
        {courses.map((course) => (
          <Grid item xs={12} sm={6} md={4} key={course.id}>
            <CourseCard course={course} />
          </Grid>
        ))}
      </Grid>

      <Dialog open={open} onClose={handleClose} maxWidth="md" fullWidth>
        <DialogTitle>
          {editingCourse ? 'Edit Course' : 'Add New Course'}
        </DialogTitle>
        <DialogContent>
          <Box sx={{ pt: 2 }}>
            <Box display="flex" gap={2}>
              <TextField
                fullWidth
                label="Course Code"
                margin="normal"
                required
              />
              <TextField
                fullWidth
                label="Course Name"
                margin="normal"
                required
              />
            </Box>
            <TextField
              fullWidth
              label="Description"
              margin="normal"
              multiline
              rows={3}
            />
            <Box display="flex" gap={2}>
              <TextField
                fullWidth
                label="Duration (Years)"
                type="number"
                margin="normal"
                required
              />
              <TextField
                fullWidth
                label="Total Fees"
                type="number"
                margin="normal"
                required
              />
            </Box>
            <FormControl fullWidth margin="normal">
              <InputLabel>Department</InputLabel>
              <Select label="Department">
                <MenuItem value="cs">Computer Science</MenuItem>
                <MenuItem value="eng">Engineering</MenuItem>
                <MenuItem value="bus">Business</MenuItem>
                <MenuItem value="arts">Arts</MenuItem>
                <MenuItem value="sci">Science</MenuItem>
              </Select>
            </FormControl>
          </Box>
        </DialogContent>
        <DialogActions>
          <Button onClick={handleClose}>Cancel</Button>
          <Button variant="contained">
            {editingCourse ? 'Update' : 'Create'}
          </Button>
        </DialogActions>
      </Dialog>
    </Box>
  );
};

export default Courses;
